package com.hakaton.nomads.domain.models.tourismTwo.details

import com.hakaton.nomads.domain.models.laboratories.details.Coordinates
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainInfo(
    val name: String,
    val city: String,
    val street: String,
    val houseNumber: String,
    @Json(name = "coordinates") val coordinates: Coordinates,
    val minDays: String,
    val maxDays: String,
    @Json(name = "photos") val photos: List<String> = ArrayList(),
    val mealPlan: String,
)
