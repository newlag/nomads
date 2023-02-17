package com.hakaton.nomads.domain.models.events.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    @Json(name = "dates") val dates: Dates,
    val name: String,
    val link: String,
    val price: String,
    val description: String,
    @Json(name = "video") val video: ArrayList<String>,
    @Json(name = "photos") val photos: ArrayList<String>,
    val type: String,
    @Json(name = "WoS")
    val wos: String
)