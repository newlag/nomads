package com.hakaton.nomads.data.repositories.remote.tourismOne

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.hakaton.nomads.domain.models.tourismOne.TourismOne
import retrofit2.Call
import retrofit2.http.GET

interface TourismOneService {
    @GET(HttpRequestTV.URL_TOURISM_ONE)
    fun requestTourismOne(): Call<List<TourismOne>>
}