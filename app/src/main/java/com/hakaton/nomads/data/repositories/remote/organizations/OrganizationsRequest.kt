package com.hakaton.nomads.data.repositories.remote.organizations

import android.util.Log
import com.hakaton.nomads.data.repositories.remote.RequestCallback
import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData
import com.hakaton.nomads.data.repositories.remote.httpConnect.RetrofitClientWrapper
import com.hakaton.nomads.domain.models.organizations.Organizations

class OrganizationsRequest {
    fun request(organizationsRequestInterface: OrganizationsRequestInterface) {
        val client = RetrofitClientWrapper().getRetrofit().create(
            OrganizationsService::class.java
        )
        client.requestTourismOne().enqueue(object : RequestCallback<List<Organizations>>() {
            override fun callCallback(body: List<Organizations>, code: Int) {
                organizationsRequestInterface.onSuccess(data = body)
                Log.d("RoomRequest", "callCallback (size: ${body.size}")
            }

            override fun failRequest(errorData: ErrorResponseData) {
                organizationsRequestInterface.onFailure(errorData = errorData)
            }
        })
    }
}