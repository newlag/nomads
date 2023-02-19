package com.hakaton.nomads.ui.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.databinding.FragmentInstitutionBinding

class InstitutionFragment : Fragment() {

    private lateinit var binding: FragmentInstitutionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstitutionBinding.inflate(inflater, container, false)
        return binding.root
    }
}