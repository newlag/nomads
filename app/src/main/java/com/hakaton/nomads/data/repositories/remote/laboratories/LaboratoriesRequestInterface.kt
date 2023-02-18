package com.hakaton.nomads.data.repositories.remote.laboratories

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.laboratories.Laboratories

interface LaboratoriesRequestInterface {
    fun onSuccess(data: List<Laboratories>)

    fun onFailure(errorData: ErrorResponseData)
}