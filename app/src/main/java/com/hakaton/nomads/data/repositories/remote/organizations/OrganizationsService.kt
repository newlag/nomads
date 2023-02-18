package com.hakaton.nomads.data.repositories.remote.organizations

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.hakaton.nomads.domain.models.organizations.Organizations
import retrofit2.Call
import retrofit2.http.GET

interface OrganizationsService {
    @GET(HttpRequestTV.URL_TOURISM_ONE)
    fun requestTourismOne(): Call<List<Organizations>>
}