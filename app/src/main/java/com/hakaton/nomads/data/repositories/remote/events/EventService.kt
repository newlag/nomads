package com.hakaton.nomads.data.repositories.remote.events

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.hakaton.nomads.domain.models.events.EventsData
import retrofit2.Call
import retrofit2.http.GET

interface EventService {
    @GET(HttpRequestTV.URL_EVENTS)
    fun requestEvents(): Call<List<EventsData>>
}