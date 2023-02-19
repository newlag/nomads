package com.hakaton.nomads.ui.fragments.habitation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.R
import com.hakaton.nomads.data.repositories.HabitationsRepositoryImpl
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentHabitationBinding
import com.hakaton.nomads.ui.fragments.BaseSecondaryFragment
import com.hakaton.nomads.ui.fragments.events.recycler.ElementAdapter
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn

class HabitationFragment : BaseSecondaryFragment(), MainRecyclerClickListener {
    var _binding: FragmentHabitationBinding? = null
    val binding get() = _binding!!
    val list = mutableListOf<SelectorMainCard>()
    val adapter = ElementAdapter(list, this)
    private val tourismTwoRepository: HabitationsRepositoryImpl = HabitationsRepositoryImpl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitationBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter =
            adapter
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        val dataList = SingletonData.getInstance().habitationstList
        if (dataList.isEmpty()) {
            tourismTwoRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0)
                .onEach {
                    if (it != null) {
                        list.clear()
                        it.map { tuk ->
                            list.add(HabitationDataClass(tuk))
                        }
                    }
                    adapter.notifyDataSetChanged()
                }.launchIn(lifecycleScope)
        } else {
            list.clear()
            dataList.map { tuk ->
                list.add(HabitationDataClass(tuk))
            }
        }

        return binding.root
    }


    override fun onDetach() {
        viewModel.showToolbar()

        super.onDetach()
    }

    override fun onClickEvent(id: String) {

    }

    override fun onClickHabitation(id: String) {
        val bundle = Bundle()
        bundle.putString("id", id)
        findNavController().navigate(R.id.habitationCardFragment, bundle)
    }
}