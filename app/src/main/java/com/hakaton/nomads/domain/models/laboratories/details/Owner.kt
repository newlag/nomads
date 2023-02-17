package com.hakaton.nomads.domain.models.laboratories.details

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Owner(
    val name: String,
    val position: String,
    val phone: String,
    val email: String
)
