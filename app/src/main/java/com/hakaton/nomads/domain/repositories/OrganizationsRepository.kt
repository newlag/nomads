package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.organizations.Organizations

interface OrganizationsRepository {

    fun getData(): LiveData<List<Organizations>?>
}