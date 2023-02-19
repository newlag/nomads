package com.hakaton.nomads.ui.fragments.profile

import com.vk.sdk.api.users.dto.UsersUserFull

interface AuthCallBack {
    fun onSuccess(result: UsersUserFull)
    fun onError()
}