package com.hakaton.nomads.domain.models.tourismTwo.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rules(
    val requiredUniDocuments: String,
    val requiredStudentsDocuments: String,
    @Json(name = "committee") val committee: Committee,
)
