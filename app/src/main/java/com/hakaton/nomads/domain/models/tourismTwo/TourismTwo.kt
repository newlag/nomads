package com.hakaton.nomads.domain.models.tourismTwo

import com.hakaton.nomads.domain.models.tourismTwo.details.Details
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TourismTwo(
    val userId: String,
    val universityId: String,
    val createdTimestamp: Long,
    val details: Details?,
    val onModeration: Boolean,
    val id: String,
    val timestamp: Long,
    val updatedTimestamp: Long,
    //@Json(name = "rooms") val rooms: Map<String, Rooms>
)
