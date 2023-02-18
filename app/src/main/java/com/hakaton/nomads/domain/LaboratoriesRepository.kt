package com.hakaton.nomads.domain

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.laboratories.Laboratories

interface LaboratoriesRepository {
    fun getData(): LiveData<List<Laboratories>?>
}