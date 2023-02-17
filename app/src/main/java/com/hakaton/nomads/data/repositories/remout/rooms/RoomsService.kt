package com.hakaton.nomads.data.repositories.remout.rooms

import com.hakaton.nomads.data.repositories.remout.HttpRequestTV
import com.hakaton.nomads.domain.models.laboratories.LaboratoriesData
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms
import retrofit2.Call
import retrofit2.http.GET

interface RoomsService {
    @GET(HttpRequestTV.URL_ROOMS)
    fun requestRooms(): Call<List<TourismRooms>>
}