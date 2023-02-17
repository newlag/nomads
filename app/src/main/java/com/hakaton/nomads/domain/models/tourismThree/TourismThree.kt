package com.hakaton.nomads.domain.models.tourismThree

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TourismThree(
    val userId: String,
    val universityId: String,
    val dormitoryId: String,
    val name: String,
    val id: String,
    val timestamp: Long,
    val createdTimestamp: Long,
    val updatedTimestamp: Long,
    val onModeration: Boolean
)