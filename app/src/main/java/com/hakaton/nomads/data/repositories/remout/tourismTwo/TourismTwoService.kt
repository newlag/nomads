package com.hakaton.nomads.data.repositories.remout.tourismTwo

import com.hakaton.nomads.data.repositories.remout.HttpRequestTV
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo
import retrofit2.Call
import retrofit2.http.GET

interface TourismTwoService {
    @GET(HttpRequestTV.URL_TOURISM_TWO)
    fun requestTourismTwo(): Call<List<TourismTwo>>
}