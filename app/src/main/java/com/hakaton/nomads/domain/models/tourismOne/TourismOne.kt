package com.hakaton.nomads.domain.models.tourismOne

import com.hakaton.nomads.domain.models.tourismOne.Details
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TourismOne(
    val userId: String,
    val name: String?,
    val description: String?,
    @Json(name = "details") val details: Details?,
    val isDebug: Boolean?,
    val onModeration: Boolean,
    val id: String,
    val timestamp: Long,
    val createdTimestamp: Long,
    val updatedTimestamp: Long
)
