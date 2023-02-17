package com.hakaton.nomads.ui.fragments.neMain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.databinding.FragmentNeMainBinding

class NeMainFragment : Fragment() {
    var _binding: FragmentNeMainBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNeMainBinding.inflate(inflater, container, false)
        return binding.root
    }

}