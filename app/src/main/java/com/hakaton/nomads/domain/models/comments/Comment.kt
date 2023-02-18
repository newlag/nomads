package com.hakaton.nomads.domain.models.comments

data class Comment(
    val comment: String,
    val userName: String,
    val userPic: String? = null
)