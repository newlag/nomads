package com.hakaton.nomads.domain.models.laboratories.details

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinates(
    val lat: Double,
    val lng: Double,
)