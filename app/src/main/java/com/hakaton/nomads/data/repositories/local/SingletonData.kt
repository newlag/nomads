package com.hakaton.nomads.data.repositories.local

import com.hakaton.nomads.domain.models.events.Events
import com.hakaton.nomads.domain.models.habitations.Habitations

class SingletonData() {
    var eventList = mutableListOf<Events>()
    var habitationstList = mutableListOf<Habitations>()


    companion object {
        private var allData: SingletonData? = null

        fun getInstance(): SingletonData {
            if (allData == null) {
                allData = SingletonData()
            }
            return allData!!
        }
    }
}