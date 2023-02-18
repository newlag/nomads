package com.hakaton.nomads.data.repositories.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hakaton.nomads.domain.repositories.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    private val auth: FirebaseAuth = Firebase.auth

    override fun isLogged(): LiveData<Boolean> {
        val logged: MutableLiveData<Boolean> = MutableLiveData()
        logged.postValue(auth.currentUser != null)
        return logged
    }

    override fun register(email: String, password: String): LiveData<Boolean> {
        val registerSuccess: MutableLiveData<Boolean> = MutableLiveData()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                registerSuccess.postValue(task.isSuccessful)
            }
        return registerSuccess
    }

    override fun login(email: String, password: String): LiveData<Boolean> {
        val loginSuccess: MutableLiveData<Boolean> = MutableLiveData()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loginSuccess.postValue(task.isSuccessful)
            }
        return loginSuccess
    }
}