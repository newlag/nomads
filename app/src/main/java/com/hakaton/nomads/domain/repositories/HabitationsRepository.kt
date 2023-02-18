package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.habitations.Habitations
import kotlinx.coroutines.flow.Flow

interface HabitationsRepository {
    fun getData(): Flow<List<Habitations>?>
}