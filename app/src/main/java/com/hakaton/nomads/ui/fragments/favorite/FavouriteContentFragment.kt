package com.hakaton.nomads.ui.fragments.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.databinding.FragmentFavouriteContentBinding

class FavouriteContentFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteContentBinding.inflate(inflater, container, false)
        return binding.root
    }
}