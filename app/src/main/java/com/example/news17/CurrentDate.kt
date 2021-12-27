package com.example.news17

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun TodayDate():String
{
    val now= LocalDateTime.now()
    val formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return formatter.format(now)
}