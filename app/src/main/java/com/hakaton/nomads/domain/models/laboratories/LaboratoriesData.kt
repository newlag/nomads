package com.hakaton.nomads.domain.models.laboratories

import com.hakaton.nomads.domain.models.laboratories.details.Details
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LaboratoriesData(
    @Json(name = "details") val details: Details,
    val userId: String,
    val universityId: String,
    val onModeration: Boolean,
    val createdTimestamp: Long?,
    val updatedTimestamp: Long,
    val id: String,
    val timestamp: Long
)
