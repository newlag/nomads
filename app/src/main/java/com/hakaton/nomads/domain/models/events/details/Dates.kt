package com.hakaton.nomads.domain.models.events.details

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dates(
    val from: Long,
    val to: Long,
    val isRegular: Boolean?
)
