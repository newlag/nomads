package com.hakaton.nomads.data.repositories.remote.events

import android.util.Log
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.events.Events

class EventsRequest {
    fun request(eventsRequestInterface: EventsRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            EventService::class.java
        )
        client.requestEvents().enqueue(object : RequestCallback<List<Events>>() {
            override fun callCallback(body: List<Events>, code: Int) {
                eventsRequestInterface.onSuccess(data = body)
            }

            override fun failRequest(errorData: ErrorResponseData) {
                eventsRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}