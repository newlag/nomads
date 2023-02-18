package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.events.Events
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    fun getData(): Flow<List<Events>?>
}