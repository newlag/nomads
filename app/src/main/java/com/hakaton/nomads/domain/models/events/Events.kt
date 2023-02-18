package com.hakaton.nomads.domain.models.events

import com.hakaton.nomads.domain.models.events.details.Details
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Events(
   @Json(name = "details") val details: Details,
   val userId: String,
   val universityId: String,
   val createdTimestamp: Long,
   val updatedTimestamp: Long,
   val onModeration: Boolean,
   val id: String,
   val timestamp: Long
)