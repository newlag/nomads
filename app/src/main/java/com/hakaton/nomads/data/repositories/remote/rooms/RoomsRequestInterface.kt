package com.hakaton.nomads.data.repositories.remote.rooms

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms

interface RoomsRequestInterface {
    fun onSuccess(data: List<TourismRooms>)

    fun onFailure(errorData: ErrorResponseData)
}