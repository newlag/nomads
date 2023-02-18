package com.hakaton.nomads.data.repositories.remote.habitations

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.hakaton.nomads.domain.models.habitations.Habitations
import retrofit2.Call
import retrofit2.http.GET

interface HabitationsService {
    @GET(HttpRequestTV.URL_TOURISM_TWO)
    fun requestTourismTwo(): Call<List<Habitations>>
}