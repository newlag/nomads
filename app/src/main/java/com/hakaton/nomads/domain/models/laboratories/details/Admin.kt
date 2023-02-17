package com.hakaton.nomads.domain.models.laboratories.details

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Admin(
    val name: String?,
    val phone: String?,
    val email: String?
)
