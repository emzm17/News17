package com.example.news17.api


import com.example.news17.constants.Constant.Companion.API_KEY

import com.example.news17.data.NewsResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

     @GET("v2/top-headlines?country=in&apiKey=$API_KEY")
     suspend fun getEverything():Response<NewsResponse>


     @GET("v2/top-headlines?country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlines(@Query("category")category:String):Response<NewsResponse>


     @GET("v2/everything?apiKey=$API_KEY&sortBy=popularity")
     suspend fun searchNews(@Query("q")query:String):Response<NewsResponse>


}
