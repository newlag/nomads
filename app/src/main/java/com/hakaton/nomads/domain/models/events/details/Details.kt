package com.hakaton.nomads.domain.models.events.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    @Json(name = "dates") val dates: Dates,
    val name: String,
    val link: String?,
    val price: String,
    val description: String,
    @Json(name = "video") val video: List<String>?,
    @Json(name = "photos") val photos: List<String>,
    val type: String,
    @Json(name = "WoS")
    val wos: String?
)