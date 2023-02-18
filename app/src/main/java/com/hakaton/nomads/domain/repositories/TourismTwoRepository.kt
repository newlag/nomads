package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.hakaton.nomads.domain.models.tourismTwo.TourismTwo

interface TourismTwoRepository {
    fun getData(): LiveData<List<TourismTwo>?>
}