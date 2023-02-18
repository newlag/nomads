package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.events.EventsRequest
import com.hakaton.nomads.data.repositories.remote.events.EventsRequestInterface
import com.hakaton.nomads.domain.models.events.Events
import com.hakaton.nomads.domain.repositories.EventsRepository

class EventsRepositoryImpl : EventsRepository {
    override fun getData(): LiveData<List<Events>?> {
        val requestData: MutableLiveData<List<Events>?> = MutableLiveData()
        EventsRequest().request(object : EventsRequestInterface {
            override fun onSuccess(data: List<Events>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }
        })
        return requestData
    }
}