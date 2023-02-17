package com.hakaton.nomads.domain.models.tourismThree

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    val isFree: Boolean,
    val type: String,
    val amount: String,
    val price: String,
    val description: String,
    @Json(name = "photos") val photos: ArrayList<String>
)