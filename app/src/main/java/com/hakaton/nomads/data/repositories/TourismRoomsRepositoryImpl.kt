package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.rooms.RoomsRequest
import com.hakaton.nomads.data.repositories.remote.rooms.RoomsRequestInterface
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms
import com.hakaton.nomads.domain.repositories.TourismRoomsRepository

class TourismRoomsRepositoryImpl : TourismRoomsRepository {
    override fun getData(): LiveData<List<TourismRooms>?> {
        val requestData: MutableLiveData<List<TourismRooms>?> = MutableLiveData()
        RoomsRequest().request(object : RoomsRequestInterface {
            override fun onSuccess(data: List<TourismRooms>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }
        })
        return requestData
    }
}