package com.hakaton.nomads.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.databinding.FragmentProfileBinding
import com.hakaton.nomads.ui.fragments.BaseSecondaryFragment

class ProfileFragment : BaseSecondaryFragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

}