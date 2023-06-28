package com.example.news17.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news17.R.layout.activity_news_list
import com.example.news17.adapter.Myadapter
import com.example.news17.data.Article
import com.example.news17.utils.Response
import com.example.news17.viewmodel.NewsViewModel
import com.example.news17.viewmodel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_news_list.*

class NewsActivity : AppCompatActivity() {
    private lateinit var viewmodel:NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_news_list)
        viewmodel = ViewModelProvider(this,NewsViewModelFactory(this))[NewsViewModel::class.java]
        val bundle:Bundle?=intent.extras
        val number=bundle!!.get("news")
        when(number){
           1->{viewmodel.getEverthing()
               toolbar1.title = "Top-Feed"
           }
            2->{viewmodel.getHeadlines("business")
                toolbar1.title = "Business"
            }
            3->{viewmodel.getHeadlines("sport")
                toolbar1.title = "Sport"
            }
            4->{viewmodel.getHeadlines("health")
                toolbar1.title = "Health"
            }
            5->{viewmodel.getHeadlines("technology")
                toolbar1.title = "Technology"
            }
            6->{viewmodel.getHeadlines("science")
                toolbar1.title = "Science"
            }
            7->{viewmodel.getHeadlines("entertainment")
                toolbar1.title = "Entertainment"
            }

       }
        val adapter=Myadapter(this)
        rcview.layoutManager=LinearLayoutManager(this)
        rcview.adapter=adapter
        val list=arrayListOf<Article>()
        viewmodel.news.observe(this, {
               when(it){
                    is Response.Loading->{
                        pgbar.visibility=View.VISIBLE
                        rcview.visibility=View.GONE
                    }
                    is Response.Success->{
                        pgbar.visibility=View.GONE
                        rcview.visibility=View.VISIBLE
                           it.data!!.articles.forEach {  i->
                               list.add(i)
                               adapter.swapData(list)
                           }
                    }
                   is Response.Error->{
                       pgbar.visibility=View.GONE
                       rcview.visibility=View.VISIBLE
                       Toast.makeText(this,it.errormessage.toString(),Toast.LENGTH_LONG).show()
                   }
               }
        })
        setSupportActionBar(toolbar1)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            
        }
    }


}