package com.hakaton.nomads.data.repositories.remote.tourismTwo

import android.util.Log
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo

class TourismTwoRequest {
    fun request(tourismTwoRequestInterface: TourismTwoRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            TourismTwoService::class.java
        )
        client.requestTourismTwo().enqueue(object : RequestCallback<List<TourismTwo>>() {
            override fun callCallback(body: List<TourismTwo>, code: Int) {
                tourismTwoRequestInterface.onSuccess(data = body)
            }

            override fun failRequest(errorData: ErrorResponseData) {
                tourismTwoRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}