package com.hakaton.nomads.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hakaton.nomads.utils.ToolbarViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseMainFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this)[ToolbarViewModel::class.java]
        viewModel.showToolbar()
        super.onViewCreated(view, savedInstanceState)
    }
}