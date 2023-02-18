package com.hakaton.nomads.data.repositories

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.habitations.HabitationsRequest
import com.hakaton.nomads.data.repositories.remote.habitations.HabitationsRequestInterface
import com.hakaton.nomads.domain.models.habitations.Habitations
import com.hakaton.nomads.domain.repositories.HabitationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HabitationsRepositoryImpl : HabitationsRepository {
    override fun getData(): Flow<List<Habitations>?> {
        val requestData: MutableStateFlow<List<Habitations>?> = MutableStateFlow(null)
        HabitationsRequest().request(object : HabitationsRequestInterface {
            override fun onSuccess(data: List<Habitations>) {
                requestData.value = data
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.value = null
            }

        })
        return requestData
    }

}