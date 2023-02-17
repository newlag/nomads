package com.hakaton.nomads.data.repositories.remout.tourismTwo

import android.util.Log
import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remout.RequestCallback
import com.hakaton.nomads.data.repositories.remout.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo

class TourismTwoRequest {
    fun request() {
        val client = RetrofitClientWrapper().getRetrofit().create(
            TourismTwoService::class.java
        )
        client.requestTourismTwo().enqueue(object : RequestCallback<List<TourismTwo>>() {
            override fun callCallback(body: List<TourismTwo>, code: Int) {
                Log.d("RoomRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                throw Exception(errorData.errorMessage)
            }
        })
    }
}