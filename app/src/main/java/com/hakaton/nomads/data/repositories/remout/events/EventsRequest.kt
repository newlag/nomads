package com.hakaton.nomads.data.repositories.remout.events

import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remout.RequestCallback
import com.hakaton.nomads.data.repositories.remout.httpConnect.RetrofitClientWrapper

class EventsRequest {
    fun requestPlaylist() {
        val client = RetrofitClientWrapper().getRetrofit().create(
            EventService::class.java
        )
        client.requestEvents().enqueue(object : RequestCallback<Any>() {
            override fun callCallback(body: Any, code: Int) {
                if (body is String) {

                }
            }

            override fun failRequest(errorData: ErrorResponseData) {
                throw Exception(errorData.errorMessage)
            }
        })
    }
}