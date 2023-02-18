package com.hakaton.nomads.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.data.repositories.remote.laboratories.LaboratoriesRequest
import com.hakaton.nomads.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    var _binding: FragmentMainBinding? = null

    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        //EventsRequest().request()
        //RoomsRequest().request()
        //TourismOneRequest().request()
        //TourismTwoRequest().request()
        LaboratoriesRequest().request()
        return binding.root
    }
}