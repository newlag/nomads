package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.events.Events

interface EventsRepository {
    fun getData(): LiveData<List<Events>?>
}