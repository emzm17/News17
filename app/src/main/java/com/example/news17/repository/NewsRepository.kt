package com.example.news17.repository

import com.example.news17.api.RetrofitHelper

object NewsRepository {
    suspend fun getEverything()=RetrofitHelper.api.getEverything()
    suspend fun getHeadlines(category:String)=RetrofitHelper.api.getTopHeadlines(category)
    suspend fun getsearch(name:String)=RetrofitHelper.api.searchNews(name)
}