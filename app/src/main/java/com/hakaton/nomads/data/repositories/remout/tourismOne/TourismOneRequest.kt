package com.hakaton.nomads.data.repositories.remout.tourismOne

import TourismOne
import android.util.Log
import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remout.RequestCallback
import com.hakaton.nomads.data.repositories.remout.httpConnect.RetrofitClientWrapper

class TourismOneRequest {
    fun request() {
        val client = RetrofitClientWrapper().getRetrofit().create(
            TourismOneService::class.java
        )
        client.requestTourismOne().enqueue(object : RequestCallback<List<TourismOne>>() {
            override fun callCallback(body: List<TourismOne>, code: Int) {
                Log.d("RoomRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                throw Exception(errorData.errorMessage)
            }
        })
    }
}