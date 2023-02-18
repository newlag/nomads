package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.tourismRooms.TourismRooms

interface TourismRoomsRepository {
    fun getData(): LiveData<List<TourismRooms>?>
}