package com.hakaton.nomads.data.repositories.local

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hakaton.nomads.domain.repositories.VKAuthRepository

private const val SHARED_PREFS: String = "nomads"
private const val ACCESS_TOKEN: String = "access_token"

class VKAuthRepositoryImpl(
    private val sharedPrefs: SharedPreferences
) : VKAuthRepository {
    override fun isLogged(activity: Activity): LiveData<Boolean> {
        val logged: MutableLiveData<Boolean> = MutableLiveData()
        val token = getAccessToken()
        if (token != null) {
            TODO("Добавить обращение к VK SDK c этим токеном и там уже менять значение лайв даты")
        } else {
            logged.postValue(false)
        }
        return logged
    }

    override fun login(activity: Activity): LiveData<Boolean> {
        val loginSuccess: MutableLiveData<Boolean> = MutableLiveData()
//        authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))

        return loginSuccess
    }

    private fun getAccessToken(): String? {
        return sharedPrefs.getString(ACCESS_TOKEN, null)
    }

    @SuppressLint("ApplySharedPref")
    private fun saveAccessToken(token: String?) {
        sharedPrefs.edit()
            .putString(ACCESS_TOKEN, token)
            .apply()
    }


    companion object {
        @JvmStatic
        fun getInstance(context: Context): VKAuthRepositoryImpl {
            return VKAuthRepositoryImpl(
                context.getSharedPreferences(
                    SHARED_PREFS,
                    Context.MODE_PRIVATE
                )
            )
        }
    }
}