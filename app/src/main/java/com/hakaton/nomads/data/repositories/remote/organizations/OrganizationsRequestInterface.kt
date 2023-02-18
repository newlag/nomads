package com.hakaton.nomads.data.repositories.remote.organizations

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.domain.models.organizations.Organizations

interface OrganizationsRequestInterface {
    fun onSuccess(data: List<Organizations>)

    fun onFailure(errorData: ErrorResponseData)
}