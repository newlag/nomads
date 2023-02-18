package com.hakaton.nomads.data.repositories.remote.tourismOne

import TourismOne
import android.util.Log
import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper

class TourismOneRequest {
    fun request(tourismOneRequestInterface: TourismOneRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            TourismOneService::class.java
        )
        client.requestTourismOne().enqueue(object : RequestCallback<List<TourismOne>>() {
            override fun callCallback(body: List<TourismOne>, code: Int) {
                tourismOneRequestInterface.onSuccess(data = body)
                Log.d("RoomRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                tourismOneRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}