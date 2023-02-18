package com.hakaton.nomads.data.repositories.remote.tourismOne

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.tourismOne.TourismOne

interface TourismOneRequestInterface {
    fun onSuccess(data: List<TourismOne>)

    fun onFailure(errorData: ErrorResponseData)
}