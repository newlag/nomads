package com.hakaton.nomads.data.repositories.remote.tourismOne

import TourismOne
import com.example.radiostation.data.request.errorResponse.ErrorResponseData

interface TourismOneRequestInterface {
    fun onSuccess(data: List<TourismOne>)

    fun onFailure(errorData: ErrorResponseData)
}