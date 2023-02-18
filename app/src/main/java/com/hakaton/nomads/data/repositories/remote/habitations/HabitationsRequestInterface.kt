package com.hakaton.nomads.data.repositories.remote.habitations

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.habitations.Habitations

interface HabitationsRequestInterface {
    fun onSuccess(data: List<Habitations>)

    fun onFailure(errorData: ErrorResponseData)
}