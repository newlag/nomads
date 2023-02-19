package com.hakaton.nomads.data.repositories.local.login

import android.content.Context
import android.content.SharedPreferences

class LoginSharadPr {

    fun getFIO(context: Context): String {
        return getSettingsPlaylist(context).getString(FIO_KEY, "")!!
    }

    fun getPhotoUri(context: Context): String {
        return getSettingsPlaylist(context).getString(PHOTO_URI_KEY, "")!!
    }

    fun getUniversity(context: Context): String {
        return getSettingsPlaylist(context).getString(UNIVERSITY_KEY, "")!!
    }

    fun setLoginId(context: Context, id: Long) {
        getSettingsPlaylist(context).edit().putLong(LOGIN_ID_KEY, id).apply()
    }

    fun setLogin(context: Context, personalData: PersonalData) {
        getSettingsPlaylist(context).edit().putBoolean(IS_LOGIN_KEY, true).apply()
        setFull(context, personalData)
    }

    fun isLogin(context: Context): Boolean {
        return getSettingsPlaylist(context).getBoolean(IS_LOGIN_KEY, false)
    }

    fun getFull(context: Context): PersonalData {
        return PersonalData(
            fio = getFIO(context),
            photoUri = getPhotoUri(context),
            university = getUniversity(context)
        )

    }

    private fun setFull(context: Context, personalData: PersonalData) {
        val shP = getSettingsPlaylist(context).edit()
        shP.putString(FIO_KEY, personalData.fio)
        shP.putString(PHOTO_URI_KEY, personalData.photoUri)
        shP.putString(UNIVERSITY_KEY, personalData.university)
        shP.apply()
    }

    fun logOut(context: Context) {
        getSettingsPlaylist(context).edit().clear().apply()
    }

    private fun getSettingsPlaylist(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
    }

    companion object {
        private const val PREFERENCES_KEY = "PLAYLIST_PREFERENCES_KEY"
        private const val FIO_KEY = "FIO_KEY"
        private const val PHOTO_URI_KEY = "PHOTO_KEY"
        private const val UNIVERSITY_KEY = "UNIVERSITY_KEY"
        private const val IS_LOGIN_KEY = "IS_LOGIN_KEY"
        private const val LOGIN_ID_KEY = "IS_LOGIN_ID_KEY"

    }
}