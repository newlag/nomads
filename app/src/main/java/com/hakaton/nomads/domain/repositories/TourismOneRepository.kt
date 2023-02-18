package com.hakaton.nomads.domain.repositories

import TourismOne
import androidx.lifecycle.LiveData

interface TourismOneRepository {

    fun getData(): LiveData<List<TourismOne>?>
}