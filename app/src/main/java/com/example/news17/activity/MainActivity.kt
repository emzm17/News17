package com.example.news17.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.example.news17.R
import com.example.news17.utils.NetworkUitls
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        if(NetworkUitls.isInternetAvailable(this)) {
            top_feed_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 1)
                startActivity(intent)
            }
            bussines_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 2)
                startActivity(intent)
            }
            sport_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 3)
                startActivity(intent)
            }
            health_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 4)
                startActivity(intent)
            }
            tech_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 5)
                startActivity(intent)
            }
            science_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 6)
                startActivity(intent)
            }
            enter_id.setOnClickListener {
                val intent = Intent(this, NewsList::class.java)
                intent.putExtra("news", 7)
                startActivity(intent)
            }
        }
        else{
           val builder=AlertDialog.Builder(this)
               builder.setTitle("Oops!")
               builder.setMessage("Looks like your offline.Please switch on your data or WiFi and restart again")
               builder.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.nav_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
              R.id.search_nav ->{
                 startActivity(Intent(this, SearchActivity::class.java))
              }
        }

        return super.onOptionsItemSelected(item)
    }
}