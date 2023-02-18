package com.hakaton.nomads.data.repositories.remote.tourismOne

import android.util.Log
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.tourismOne.TourismOne

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