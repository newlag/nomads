package com.hakaton.nomads.data.repositories.remout.events

import com.hakaton.nomads.data.repositories.remout.HttpRequestTV
import retrofit2.Call
import retrofit2.http.GET

interface EventService {
    @GET(HttpRequestTV.URL_EVENTS)
    fun requestEvents(): Call<Any>
}