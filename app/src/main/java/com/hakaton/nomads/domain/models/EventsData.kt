package com.hakaton.nomads.domain.models

data class EventsData(
    val eventId: Int,
    val title: String,
    val track: String,
    val specialization: String,
    val url: String,
    val cost: Int,
    val date: String,
    val description: String,
    val regionCode: Int,
    val regionName: String,
    val photos: ArrayList<String> = ArrayList()
)