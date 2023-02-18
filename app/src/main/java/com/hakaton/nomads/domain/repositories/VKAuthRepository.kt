package com.hakaton.nomads.domain.repositories

import android.app.Activity
import androidx.lifecycle.LiveData

interface VKAuthRepository {
    fun isLogged(activity: Activity): LiveData<Boolean>

    fun login(activity: Activity): LiveData<Boolean>
}