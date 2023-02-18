package com.hakaton.nomads.data.repositories.remote.habitations

import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.habitations.Habitations

class HabitationsRequest {
    fun request(habitationsRequestInterface: HabitationsRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            HabitationsService::class.java
        )
        client.requestTourismTwo().enqueue(object : RequestCallback<List<Habitations>>() {
            override fun callCallback(body: List<Habitations>, code: Int) {
                habitationsRequestInterface.onSuccess(data = body)
            }

            override fun failRequest(errorData: ErrorResponseData) {
                habitationsRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}