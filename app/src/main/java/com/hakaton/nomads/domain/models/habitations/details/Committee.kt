package com.hakaton.nomads.domain.models.habitations.details

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Committee(
    val email: String,
    val phone: String,
    val name: String
)
