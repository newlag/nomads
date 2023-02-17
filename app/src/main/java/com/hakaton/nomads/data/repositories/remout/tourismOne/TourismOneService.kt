package com.hakaton.nomads.data.repositories.remout.tourismOne

import com.hakaton.nomads.data.repositories.remout.HttpRequestTV
import com.hakaton.nomads.domain.models.tourismOne.TourismOne
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms
import retrofit2.Call
import retrofit2.http.GET

interface TourismOneService {
    @GET(HttpRequestTV.URL_TOURISM_ONE)
    fun requestTourismOne(): Call<List<TourismOne>>
}