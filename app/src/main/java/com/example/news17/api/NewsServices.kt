package com.example.news17.api

import com.example.news17.TodayDate
import com.example.news17.constants.Constant
import com.example.news17.constants.Constant.Companion.API_KEY
import com.example.news17.constants.Constant.Companion.today
import com.example.news17.data.NewsResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

     @GET("v2/top-headlines?country=in&apiKey=$API_KEY")
     suspend fun getEverything():Response<NewsResponse>


     @GET("v2/top-headlines?category=technology&country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlinesTechnology():Response<NewsResponse>


     @GET("v2/top-headlines?category=sport&country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlinesSport():Response<NewsResponse>



     @GET("v2/top-headlines?category=business&country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlinesBusiness():Response<NewsResponse>




     @GET("v2/top-headlines?category=health&country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlinesHealth():Response<NewsResponse>





     @GET("v2/top-headlines?category=science&country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlinesScience():Response<NewsResponse>




     @GET("v2/top-headlines?category=entertainment&country=in&apiKey=$API_KEY")
     suspend fun getTopHeadlinesEntertainment():Response<NewsResponse>




     @GET("v2/everything?apiKey=$API_KEY&sortBy=popularity")
     suspend fun searchNews(@Query("q")query:String):Response<NewsResponse>


}
