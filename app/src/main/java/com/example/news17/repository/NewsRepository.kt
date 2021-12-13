package com.example.news17.repository

import com.example.news17.api.RetrofitHelper

object NewsRepository {
    suspend fun getEverything()=RetrofitHelper.api.getEverything()
    suspend fun getBusiness()=RetrofitHelper.api.getTopHeadlinesBusiness()
    suspend fun getSport()=RetrofitHelper.api.getTopHeadlinesSport()
    suspend fun getEntertainment()=RetrofitHelper.api.getTopHeadlinesEntertainment()
    suspend fun getMedical()=RetrofitHelper.api.getTopHeadlinesHealth()
    suspend fun getTechnology()=RetrofitHelper.api.getTopHeadlinesTechnology()
    suspend fun getScience()=RetrofitHelper.api.getTopHeadlinesScience()
}