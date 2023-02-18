package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.tourismOne.TourismOne

interface TourismOneRepository {

    fun getData(): LiveData<List<TourismOne>?>
}