package com.hakaton.nomads.domain.models.tourismTwo.details.rooms

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Json(name = "rooms")
data class Rooms(
   val test: String = "",
   val type: String = "default"
//   @Json(name = "details") val details: Details,
//   val dormitoryId: String,
//   val userId: String,
//   val universityId: String,
//   val createdTimestamp: Long,
//   val onModeration: Boolean,
//   val updatedTimestamp: Long,
//   val id: Long,
//   val timestamp: Long

)
