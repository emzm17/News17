package com.example.news17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.news17.api.RetrofitHelper
import com.example.news17.data.Article
import com.example.news17.data.NewsResponse
import com.example.news17.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        top_feed_id.setOnClickListener {
           val intent=Intent(this,NewsList::class.java)
            intent.putExtra("news",1)
            startActivity(intent)
        }
        bussines_id.setOnClickListener {
            val intent=Intent(this,NewsList::class.java)
            intent.putExtra("news",2)
            startActivity(intent)
        }
        sport_id.setOnClickListener {
            val intent=Intent(this,NewsList::class.java)
            intent.putExtra("news",3)
            startActivity(intent)
        }
        health_id.setOnClickListener {
             val intent=Intent(this,NewsList::class.java)
             intent.putExtra("news",4)
             startActivity(intent)
         }
        tech_id.setOnClickListener {
            val intent=Intent(this,NewsList::class.java)
            intent.putExtra("news",5)
            startActivity(intent)
        }
        science_id.setOnClickListener {
            val intent=Intent(this,NewsList::class.java)
            intent.putExtra("news",6)
            startActivity(intent)
        }
        enter_id.setOnClickListener {
            val intent=Intent(this,NewsList::class.java)
            intent.putExtra("news",7)
            startActivity(intent)
        }

    }
}