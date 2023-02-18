package com.hakaton.nomads.data.repositories.remout.tourismOne

import TourismOne
import com.hakaton.nomads.data.repositories.remout.HttpRequestTV
import retrofit2.Call
import retrofit2.http.GET

interface TourismOneService {
    @GET(HttpRequestTV.URL_TOURISM_ONE)
    fun requestTourismOne(): Call<List<TourismOne>>
}