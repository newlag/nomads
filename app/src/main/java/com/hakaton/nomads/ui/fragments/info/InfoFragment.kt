package com.hakaton.nomads.ui.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hakaton.nomads.databinding.FragmentInfoBinding
import com.hakaton.nomads.ui.fragments.BaseMainFragment
import com.hakaton.nomads.ui.fragments.favorite.FavouriteContentFragment
import com.hakaton.nomads.ui.fragments.favorite.FavouriteReserveFragment
import com.hakaton.nomads.ui.fragments.favorite.TabAdapter

class InfoFragment : BaseMainFragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        val names = listOf("Новости", "Организации", "Учреждения")
        val fragments = listOf(NewsFragment(), OrganizationsFragment(), InstitutionFragment())
        val adapter = TabAdapter(names, fragments, childFragmentManager)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        return binding.root
    }
}