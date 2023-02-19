package com.hakaton.nomads.ui.fragments.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.databinding.FragmentFavoriteBinding
import com.hakaton.nomads.ui.fragments.BaseMainFragment

class FavoriteFragment : BaseMainFragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val names = listOf("Избранное", "Бронирование")
        val fragments = listOf(FavouriteContentFragment(), FavouriteReserveFragment())
        val adapter = TabAdapter(names, fragments, childFragmentManager)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        return binding.root
    }

}