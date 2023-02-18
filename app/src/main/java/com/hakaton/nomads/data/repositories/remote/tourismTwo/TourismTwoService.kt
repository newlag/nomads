package com.hakaton.nomads.data.repositories.remote.tourismTwo

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo
import retrofit2.Call
import retrofit2.http.GET

interface TourismTwoService {
    @GET(HttpRequestTV.URL_TOURISM_TWO)
    fun requestTourismTwo(): Call<List<TourismTwo>>
}