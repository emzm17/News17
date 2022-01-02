package com.example.news17.api


import com.example.news17.constants.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {


   private val retrofit=Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()

    val api= retrofit.create(NewsServices::class.java)
}