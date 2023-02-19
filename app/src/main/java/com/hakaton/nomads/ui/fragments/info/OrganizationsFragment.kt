package com.hakaton.nomads.ui.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.databinding.FragmentOrganizationsBinding

class OrganizationsFragment : Fragment() {

    private lateinit var binding: FragmentOrganizationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrganizationsBinding.inflate(inflater, container, false)
        return binding.root
    }
}