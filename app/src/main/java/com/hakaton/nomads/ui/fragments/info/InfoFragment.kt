package com.hakaton.nomads.ui.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hakaton.nomads.databinding.FragmentInfoBinding
import com.hakaton.nomads.ui.fragments.BaseMainFragment

class InfoFragment : BaseMainFragment() {
    var _binding: FragmentInfoBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
}