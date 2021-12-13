package com.example.news17.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news17.data.NewsResponse
import com.example.news17.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
     val newsLiveData=MutableLiveData<NewsResponse>()
     val news:LiveData<NewsResponse>
     get()=newsLiveData

     fun getEverything(){
          GlobalScope.launch (Dispatchers.IO){
              val result=NewsRepository.getEverything()
              if(result.isSuccessful){
                   newsLiveData.postValue(result.body())
              }
          }
     }
}