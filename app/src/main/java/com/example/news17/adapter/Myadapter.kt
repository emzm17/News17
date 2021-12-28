package com.example.news17.adapter

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView

import com.example.news17.R
import com.example.news17.data.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_list.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class Myadapter(val context:Context) : RecyclerView.Adapter<NewsViewHolder>() {
 private var data:List<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent, false)

        return NewsViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
         val news=data[position]
           holder.bind(data[position])

        holder.itemView.setOnClickListener {


            val Url=news.url
            val builder=CustomTabsIntent.Builder()
            val intent=builder.build()
            intent.launchUrl(context,Uri.parse(Url))
          }
    }

    override fun getItemCount(): Int {
           return  data.size
    }
    fun swapData( data:List<Article>){
          this.data= data
        notifyDataSetChanged()
    }

}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
     @RequiresApi(Build.VERSION_CODES.O)
     fun bind(item:Article)= with(itemView){
             title.text=item.title
             source.text=item.source.name
         val dateTime: ZonedDateTime = ZonedDateTime.parse(item.publishedAt)
         val res = dateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata")).format(DateTimeFormatter.ofPattern( "hh:mm a | dd-MM-yyyy"))
         time.text=res
         Picasso.get().load(item.urlToImage).into(image)
     }

}