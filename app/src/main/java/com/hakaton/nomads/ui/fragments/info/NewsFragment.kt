package com.hakaton.nomads.ui.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.R
import com.hakaton.nomads.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.cardOne.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("id", 0)
            findNavController().navigate(R.id.newsMoreFragment,bundle)
        }
        binding.cardTwo.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("id", 1)
            findNavController().navigate(R.id.newsMoreFragment,bundle)
        }
        binding.cardThree.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("id", 2)
            findNavController().navigate(R.id.newsMoreFragment,bundle)
        }
        return binding.root
    }
}