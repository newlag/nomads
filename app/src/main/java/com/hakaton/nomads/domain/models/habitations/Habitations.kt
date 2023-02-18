package com.hakaton.nomads.domain.models.habitations

import com.hakaton.nomads.domain.models.habitations.details.Details
import com.hakaton.nomads.domain.models.habitations.details.rooms.Rooms
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Habitations(
    val userId: String,
    val universityId: String,
    val createdTimestamp: Long,
    val details: Details?,
    val onModeration: Boolean,
    val id: String,
    val timestamp: Long,
    val updatedTimestamp: Long,
    @Json(name = "rooms") val rooms: Map<String, Rooms>
)
