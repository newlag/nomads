package com.hakaton.nomads.ui.fragments.habitation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hakaton.nomads.data.repositories.HabitationsRepositoryImpl
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentHabitationBinding
import com.hakaton.nomads.ui.fragments.events.recycler.ElementAdapter
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.ToolbarViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn

class HabitationFragment : Fragment(), MainRecyclerClickListener {
    var _binding: FragmentHabitationBinding? = null
    val binding get() = _binding!!
    val list = mutableListOf<SelectorMainCard>()
    val adapter = ElementAdapter(list, this)
    private val tourismTwoRepository: HabitationsRepositoryImpl = HabitationsRepositoryImpl()
    lateinit var viewModel: ToolbarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ToolbarViewModel::class.java]
        viewModel.hideToolbar()
        binding.recyclerView.adapter =
            adapter
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

    override fun onClickEvent() {

    }

    override fun onClickHabitation() {

    }

    override fun onDetach() {
        viewModel.showToolbar()

        super.onDetach()
    }
}