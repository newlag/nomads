package com.hakaton.nomads.domain.models.laboratories.details

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Unit(
    val name: String?,
    val phone: String?,
    val email: String?
)
