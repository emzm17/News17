package com.example.news17.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news17.R
import com.example.news17.adapter.Myadapter
import com.example.news17.data.Article
import com.example.news17.viewmodel.NewsViewModel
import com.example.news17.viewmodel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private lateinit var viewmodel: NewsViewModel
    val list=arrayListOf<Article>()
    var adapter=Myadapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar2)
            supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

        }
        viewmodel = ViewModelProvider(this, NewsViewModelFactory(this))[NewsViewModel::class.java]
        rcview_search.layoutManager=LinearLayoutManager(this)
        rcview_search.adapter=adapter
        search_view.isSubmitButtonEnabled=true
        search_view.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
              query.let {
                  getNews(query)
              }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               return true
            }

        })


    }

    private fun getNews(query: String?) {
        if (query != null) {
            viewmodel.search(query)
        }
        viewmodel.searchnew.observe(this, Observer {
                  list.clear()
                   list.addAll(it)
                   adapter.swapData(list)

        })
    }
}