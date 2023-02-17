package com.hakaton.nomads.data.repositories.remout.laboratories

import android.util.Log
import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remout.RequestCallback
import com.hakaton.nomads.data.repositories.remout.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.laboratories.LaboratoriesData

class LaboratoriesRequest {
    fun request() {
        val client = RetrofitClientWrapper().getRetrofit().create(
            LaboratoriesService::class.java
        )
        client.requestLabs().enqueue(object : RequestCallback<List<LaboratoriesData>>() {
            override fun callCallback(body: List<LaboratoriesData>, code: Int) {
                Log.d("LaboratoriesRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                throw Exception(errorData.errorMessage)
            }
        })
    }
}