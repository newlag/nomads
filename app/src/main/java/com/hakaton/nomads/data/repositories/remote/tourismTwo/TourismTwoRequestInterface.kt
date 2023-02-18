package com.hakaton.nomads.data.repositories.remote.tourismTwo

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo

interface TourismTwoRequestInterface {
    fun onSuccess(data: List<TourismTwo>)

    fun onFailure(errorData: ErrorResponseData)
}