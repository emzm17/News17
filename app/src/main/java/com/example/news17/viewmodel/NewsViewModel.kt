package com.example.news17.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news17.data.Article
import com.example.news17.data.NewsResponse
import com.example.news17.repository.NewsRepository

import com.example.news17.utils.NetworkUitls
import com.example.news17.utils.Response

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(private val context: Context) : ViewModel() {
     private val newsLiveData=MutableLiveData<Response<NewsResponse>>()
     private val searchLiveData=MutableLiveData<List<Article>>()
     val searchnew:LiveData<List<Article>>
     get() = searchLiveData
     val news:LiveData<Response<NewsResponse>>
     get()=newsLiveData


    fun getEverthing(){
        if(NetworkUitls.isInternetAvailable(context)) {
            try {
                GlobalScope.launch(Dispatchers.IO) {
                    val result = NewsRepository.getEverything()
                    if (result.code() == 200) {
                        newsLiveData.postValue(Response.Success(result.body()!!))
                    }
                }
            } catch (e:Exception){
                newsLiveData.postValue(Response.Error("Error Loading the Page"))
            }

        }
        else{
             newsLiveData.postValue(Response.Error("Error Loading the Page"))
        }
    }



    fun getHeadlines(category:String){
        if(NetworkUitls.isInternetAvailable(context)) {
            try {
                GlobalScope.launch(Dispatchers.IO) {
                    val result = NewsRepository.getHeadlines(category)
                    if (result.code() == 200) {
                        newsLiveData.postValue(Response.Success(result.body()!!))
                    }
                }
            } catch (e:Exception){
                newsLiveData.postValue(Response.Error("Error Loading the Page"))
            }

        }
        else{
            newsLiveData.postValue(Response.Error("Error Loading the Page"))
        }
    }


    fun search(name:String){
         GlobalScope.launch(Dispatchers.IO) {
             val result=NewsRepository.getsearch(name)
             if(result.isSuccessful){
                 result.body().let {
                     searchLiveData.postValue(it!!.articles)
                 }

             }
         }
    }


}