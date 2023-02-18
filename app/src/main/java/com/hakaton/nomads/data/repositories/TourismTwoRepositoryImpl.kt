package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.tourismTwo.TourismTwoRequest
import com.hakaton.nomads.data.repositories.remote.tourismTwo.TourismTwoRequestInterface
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo
import com.hakaton.nomads.domain.repositories.TourismTwoRepository

class TourismTwoRepositoryImpl: TourismTwoRepository {
    override fun getData(): LiveData<List<TourismTwo>?> {
        val requestData: MutableLiveData<List<TourismTwo>?> = MutableLiveData()
        TourismTwoRequest().request(object : TourismTwoRequestInterface {
            override fun onSuccess(data: List<TourismTwo>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }

        })
        return requestData
    }

}