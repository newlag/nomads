package com.hakaton.nomads.data.repositories.remout.rooms

import android.util.Log
import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remout.RequestCallback
import com.hakaton.nomads.data.repositories.remout.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms

class RoomsRequest {
    fun request() {
        val client = RetrofitClientWrapper().getRetrofit().create(
            RoomsService::class.java
        )
        client.requestRooms().enqueue(object : RequestCallback<List<TourismRooms>>() {
            override fun callCallback(body: List<TourismRooms>, code: Int) {
                Log.d("RoomRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                throw Exception(errorData.exception)
            }
        })
    }
}