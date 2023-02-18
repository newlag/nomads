package com.hakaton.nomads.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.organizations.OrganizationsRequest
import com.hakaton.nomads.data.repositories.remote.organizations.OrganizationsRequestInterface
import com.hakaton.nomads.domain.models.organizations.Organizations
import com.hakaton.nomads.domain.repositories.OrganizationsRepository

class OrganizationsRepositoryImpl : OrganizationsRepository {
    override fun getData(): LiveData<List<Organizations>?> {
        val requestData: MutableLiveData<List<Organizations>?> = MutableLiveData()
        OrganizationsRequest().request(object : OrganizationsRequestInterface {
            override fun onSuccess(data: List<Organizations>) {
                requestData.postValue(data)
            }

            override fun onFailure(errorData: ErrorResponseData) {
                requestData.postValue(null)
            }
        })
        return requestData
    }
}
