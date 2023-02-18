package com.hakaton.nomads.data.repositories.remote.events

import android.util.Log
import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.events.EventsData

class EventsRequest {
    fun request() {
        val client = RetrofitClientWrapper().getRetrofit().create(
            EventService::class.java
        )
        client.requestEvents().enqueue(object : RequestCallback<List<EventsData>>() {
            override fun callCallback(body: List<EventsData>, code: Int) {
                Log.d("EventRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                throw Exception(errorData.errorMessage)
            }
        })
    }
}