package com.hakaton.nomads.domain.models

data class NewsData(
    val title: String,
    val description: String,
    val imageUrl: String,
    val tags: ArrayList<String>,
)