package com.hakaton.nomads.domain.models.tourismRooms

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TourismRooms(
    val userId: String,
    val universityId: String,
    val dormitoryId: String,
    val name: String?,
    val details: Details?,
    val id: String,
    val timestamp: Long,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val onModeration: Boolean
)