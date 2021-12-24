package com.example.news17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news17.R.layout.activity_news_list
import com.example.news17.adapter.Myadapter
import com.example.news17.data.Article
import com.example.news17.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_news_list.*

class NewsList : AppCompatActivity() {
    private lateinit var viewmodel:NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_news_list)
        viewmodel = ViewModelProvider(this)[NewsViewModel::class.java]
        val bundle:Bundle?=intent.extras
       val number=bundle!!.get("news")
       when(number){
           1->viewmodel.getEverything()
           2->viewmodel.getBusiness()
           3->viewmodel.getSport()
           4->viewmodel.getHealth()
           5->viewmodel.getTech()
           6->viewmodel.getScience()
           7->viewmodel.getEntertainment()

       }
        val adapter=Myadapter()
        rcview.layoutManager=LinearLayoutManager(this)
        rcview.adapter=adapter


         val list=arrayListOf<Article>()
        viewmodel.news.observe(this, { data->
              data.articles.forEach {
                   list.add(it)
                  adapter.swapData(list)
              }

        })

    }
}