package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.tourismOne.TourismOneRequest
import com.hakaton.nomads.data.repositories.remote.tourismOne.TourismOneRequestInterface
import com.hakaton.nomads.domain.models.tourismOne.TourismOne
import com.hakaton.nomads.domain.repositories.TourismOneRepository

class TourismOneRepositoryImpl : TourismOneRepository {
    override fun getData(): LiveData<List<TourismOne>?> {
        val requestData: MutableLiveData<List<TourismOne>?> = MutableLiveData()
        TourismOneRequest().request(object : TourismOneRequestInterface {
            override fun onSuccess(data: List<TourismOne>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }
        })
        return requestData
    }
}
