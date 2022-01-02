package com.example.news17.constants

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Constant {
    @RequiresApi(Build.VERSION_CODES.O)
    companion object{
      const  val BASE_URL= "https://newsapi.org/"
      const  val API_KEY="e6904319d5af465a94502a582585f96f"
    }

}