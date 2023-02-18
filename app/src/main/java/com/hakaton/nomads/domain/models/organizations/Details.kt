package com.hakaton.nomads.domain.models.organizations

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Details(
    val photo: String?,
    val name: String?,
    val site: String?,
    @Json(name = "committee") val committee: String?,
    val region: String?,
    val shortName: String?,
    val district: String?,
    val founderName: String?
)
