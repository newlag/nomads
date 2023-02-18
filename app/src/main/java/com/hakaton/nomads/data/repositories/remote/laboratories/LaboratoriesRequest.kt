package com.hakaton.nomads.data.repositories.remote.laboratories

import android.util.Log
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.laboratories.Laboratories

class LaboratoriesRequest {
    fun request(laboratoriesRequestInterface: LaboratoriesRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            LaboratoriesService::class.java
        )
        client.requestLabs().enqueue(object : RequestCallback<List<Laboratories>>() {
            override fun callCallback(body: List<Laboratories>, code: Int) {
                laboratoriesRequestInterface.onSuccess(data = body)
            }

            override fun failRequest(errorData: ErrorResponseData) {
                laboratoriesRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}