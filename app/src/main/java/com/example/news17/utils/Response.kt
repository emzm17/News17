package com.example.news17.utils

import com.example.news17.data.NewsResponse
import java.lang.Exception



sealed class Response<T>(val data:T?=null,val errormessage: String?=null){
    class Loading<T>:Response<T>()
    class Success<T>(data:T?=null):Response<T>(data=data)
    class Error<T>(errormessage: String):Response<T>(errormessage = errormessage)
}