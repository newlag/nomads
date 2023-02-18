package com.hakaton.nomads.data.repositories.remote.events

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.events.Events

interface EventsRequestInterface {
    fun onSuccess(data: List<Events>)

    fun onFailure(errorData: ErrorResponseData)
}