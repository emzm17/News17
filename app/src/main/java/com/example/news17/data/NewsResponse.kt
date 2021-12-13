package com.example.news17.data

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)