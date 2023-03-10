package com.hakaton.nomads.domain.models.habitations.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    @Json(name = "main-info") val mainInfo: MainInfo?,
    val rules:Rules?
)
