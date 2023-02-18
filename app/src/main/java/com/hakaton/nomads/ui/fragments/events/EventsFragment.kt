package com.hakaton.nomads.ui.fragments.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hakaton.nomads.data.repositories.EventsRepositoryImpl
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentEventsBinding
import com.hakaton.nomads.ui.fragments.events.recycler.ElementAdapter
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.ToolbarViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn

class EventsFragment : Fragment(), MainRecyclerClickListener {
    var _binding: FragmentEventsBinding? = null
    val binding get() = _binding!!

    val list = mutableListOf<SelectorMainCard>()
    val adapter = ElementAdapter(list, this)
    private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()
    lateinit var viewModel: ToolbarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter =
            adapter
        viewModel = ViewModelProvider(requireActivity())[ToolbarViewModel::class.java]
        viewModel.hideToolbar()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dataList = SingletonData.getInstance().eventList
        if (dataList.isEmpty()) {
            eventsRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0).onEach {
                if (it != null) {
                    list.clear()
                    it.map { tuk ->
                        list.add(EventMainDataClass(tuk))
                    }
                }
                adapter.notifyDataSetChanged()
            }.launchIn(lifecycleScope)
        } else {
            list.clear()
            dataList.map { tuk ->
                list.add(EventMainDataClass(tuk))
            }
        }

        super.onViewCreated(view, savedInstanceState)
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