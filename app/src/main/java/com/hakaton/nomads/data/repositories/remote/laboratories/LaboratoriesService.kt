package com.hakaton.nomads.data.repositories.remote.laboratories

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.hakaton.nomads.domain.models.laboratories.LaboratoriesData
import retrofit2.Call
import retrofit2.http.GET

interface LaboratoriesService {
    @GET(HttpRequestTV.URL_LABORATORIES)
    fun requestLabs(): Call<List<LaboratoriesData>>
}