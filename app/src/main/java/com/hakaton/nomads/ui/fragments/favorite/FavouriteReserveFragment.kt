package com.hakaton.nomads.ui.fragments.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.databinding.FragmentFavouriteReserveBinding

class FavouriteReserveFragment : Fragment() {

   private lateinit var binding: FragmentFavouriteReserveBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteReserveBinding.inflate(inflater, container, false)
        return binding.root
    }
}