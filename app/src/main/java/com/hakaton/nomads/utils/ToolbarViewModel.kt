package com.hakaton.nomads.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

class ToolbarViewModel : ViewModel() {
    private val defaultToolBarState = MutableStateFlow(true)
    fun getStateFlow() = defaultToolBarState.shareIn(viewModelScope, SharingStarted.Eagerly, 0)

    fun hideToolbar() {
        defaultToolBarState.value = false
    }

    fun showToolbar() {
        defaultToolBarState.value = true
    }

}


