package com.hakaton.nomads.domain.models.laboratories.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    val name: String?,
    val link: String?,
    val description: String?,
    @Json(name = "photos") val photos: List<String> = listOf(),
    @Json(name = "coordinates") val coordinates: Coordinates?,
    @Json(name = "owner") val owner: Owner?,
    @Json(name = "unit") val unit: Unit?,
    @Json(name = "admin") val admin: Admin?,
    val shortDescription: String?,
)