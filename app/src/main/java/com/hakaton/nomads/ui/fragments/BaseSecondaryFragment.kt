package com.hakaton.nomads.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hakaton.nomads.utils.ToolbarViewModel

abstract class BaseSecondaryFragment : Fragment(){
    lateinit var viewModel: ToolbarViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity())[ToolbarViewModel::class.java]
        viewModel.hideToolbar()
        super.onViewCreated(view, savedInstanceState)
    }
}