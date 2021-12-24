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
     private val newsLiveData=MutableLiveData<NewsResponse>()
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
    fun getBusiness(){
        GlobalScope.launch (Dispatchers.IO){
            val result=NewsRepository.getBusiness()
            if(result.isSuccessful){

                newsLiveData.postValue(result.body())
            }
        }
    }
    fun getSport(){
        GlobalScope.launch (Dispatchers.IO){
            val result=NewsRepository.getSport()
            if(result.isSuccessful){
                newsLiveData.postValue(result.body())
            }
        }
    }
    fun getTech(){
        GlobalScope.launch (Dispatchers.IO){
            val result=NewsRepository.getTechnology()
            if(result.isSuccessful){
                newsLiveData.postValue(result.body())
            }
        }
    }
    fun getScience(){
        GlobalScope.launch (Dispatchers.IO){
            val result=NewsRepository.getScience()
            if(result.isSuccessful){
                newsLiveData.postValue(result.body())
            }
        }
    }
    fun getHealth(){
        GlobalScope.launch (Dispatchers.IO){
            val result=NewsRepository.getMedical()
            if(result.isSuccessful){
                newsLiveData.postValue(result.body())
            }
        }
    }
    fun getEntertainment(){
        GlobalScope.launch (Dispatchers.IO){
            val result=NewsRepository.getEntertainment()
            if(result.isSuccessful){
                newsLiveData.postValue(result.body())
            }
        }
    }


}