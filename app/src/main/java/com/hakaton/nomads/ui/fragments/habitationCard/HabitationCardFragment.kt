package com.hakaton.nomads.ui.fragments.habitationCard

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.data.repositories.CommentsRepositoryImpl
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentHabitationCardBinding
import com.hakaton.nomads.domain.models.habitations.Habitations
import com.hakaton.nomads.ui.fragments.BaseSecondaryFragment
import com.hakaton.nomads.utils.GlideWrapper

class HabitationCardFragment : BaseSecondaryFragment() {
    var _binding: FragmentHabitationCardBinding? = null
    val binding get() = _binding!!
    lateinit var data: Habitations

    override fun onAttach(context: Context) {
        val dataList = SingletonData.getInstance().habitationstList

        arguments?.let {
            val playlistId = it.getString("id")
            data = dataList.find { hab ->
                hab.id == playlistId
            }!!
        }
        super.onAttach(context)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitationCardBinding.inflate(inflater, container, false)
        try {
            GlideWrapper(requireContext()).loadImageNoCash(
                binding.mainImage,
                data.details!!.mainInfo!!.photos[0]
            )
        } catch (_: Exception) {

        }
        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        data.details?.mainInfo?.let {
            binding.textViewName.text = it.name
            binding.textViewAdres.text = it.city + ", ул. " + it.street
            binding.textView7.text = "от " + it.minDays + " до " + it.maxDays

        }
        data.details?.rules?.let {
            binding.textViewOrganization.text = it.committee.name
        }
        var price = Int.MAX_VALUE
        try {
            data.rooms.map {
                val value = it.value.details.price.toInt()
                if (value < price) {
                    price = value
                }
            }
        } catch (_: Exception) {
            price = 0
        }
        binding.textViewPrice.text = "от $price"
        val com = CommentsRepositoryImpl().getCommentsForHabitation("").get(0)
        binding.textView10.text = com.userName
        binding.textView11.text = com.comment
        binding.retingOtziv.text = (1..5).random().toString()
        return binding.root
    }
}