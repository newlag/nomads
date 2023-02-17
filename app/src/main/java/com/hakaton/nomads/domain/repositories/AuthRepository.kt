package com.hakaton.nomads.domain.repositories

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    fun isLogged(): LiveData<Boolean>

    fun register(email: String, password: String): LiveData<Boolean>

    fun login(email: String, password: String): LiveData<Boolean>
}