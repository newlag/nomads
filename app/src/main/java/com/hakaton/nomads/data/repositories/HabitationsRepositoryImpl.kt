package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.habitations.HabitationsRequest
import com.hakaton.nomads.data.repositories.remote.habitations.HabitationsRequestInterface
import com.hakaton.nomads.domain.models.habitations.Habitations
import com.hakaton.nomads.domain.repositories.HabitationsRepository

class HabitationsRepositoryImpl: HabitationsRepository {
    override fun getData(): LiveData<List<Habitations>?> {
        val requestData: MutableLiveData<List<Habitations>?> = MutableLiveData()
        HabitationsRequest().request(object : HabitationsRequestInterface {
            override fun onSuccess(data: List<Habitations>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }

        })
        return requestData
    }

}