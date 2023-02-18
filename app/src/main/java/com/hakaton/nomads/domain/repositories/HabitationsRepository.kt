package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.habitations.Habitations

interface HabitationsRepository {
    fun getData(): LiveData<List<Habitations>?>
}