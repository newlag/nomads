package com.hakaton.nomads.data.repositories.remote.rooms

import android.util.Log
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms

class RoomsRequest {
    fun request(roomsRequestInterface: RoomsRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            RoomsService::class.java
        )
        client.requestRooms().enqueue(object : RequestCallback<List<TourismRooms>>() {
            override fun callCallback(body: List<TourismRooms>, code: Int) {
                roomsRequestInterface.onSuccess(data = body)
            }

            override fun failRequest(errorData: ErrorResponseData) {
                roomsRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}