package com.hakaton.nomads.data.repositories

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.events.EventsRequest
import com.hakaton.nomads.data.repositories.remote.events.EventsRequestInterface
import com.hakaton.nomads.domain.models.events.Events
import com.hakaton.nomads.domain.repositories.EventsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class EventsRepositoryImpl : EventsRepository {
    override fun getData(): Flow<List<Events>?> {
        val requestData: MutableStateFlow<List<Events>?> = MutableStateFlow(null)

        EventsRequest().request(object : EventsRequestInterface {
            override fun onSuccess(data: List<Events>) {
                requestData.value = data
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.value = null
            }
        })
        return requestData
    }
}