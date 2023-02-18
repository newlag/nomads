package com.hakaton.nomads.domain.models.tourismTwo.details.rooms

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    val isFree: Boolean,
    val type: String,
    val description: String,
    @Json(name = "photos") val photos: List<String> = ArrayList(),
    val amount: String,
    val price: String,
)
