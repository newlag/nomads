package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.laboratories.LaboratoriesRequest
import com.hakaton.nomads.data.repositories.remote.laboratories.LaboratoriesRequestInterface
import com.hakaton.nomads.domain.LaboratoriesRepository
import com.hakaton.nomads.domain.models.laboratories.Laboratories

class LaboratoriesRepositoryImpl : LaboratoriesRepository {
    override fun getData(): LiveData<List<Laboratories>?> {
        val requestData: MutableLiveData<List<Laboratories>?> = MutableLiveData()
        LaboratoriesRequest().request(object : LaboratoriesRequestInterface {
            override fun onSuccess(data: List<Laboratories>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }

        })
        return requestData
    }
}