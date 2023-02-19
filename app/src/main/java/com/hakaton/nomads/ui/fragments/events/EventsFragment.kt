package com.hakaton.nomads.ui.fragments.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.R
import com.hakaton.nomads.data.repositories.EventsRepositoryImpl
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentEventsBinding
import com.hakaton.nomads.ui.fragments.BaseSecondaryFragment
import com.hakaton.nomads.ui.fragments.events.recycler.ElementAdapter
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.ToolbarViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn

class EventsFragment : BaseSecondaryFragment(), MainRecyclerClickListener {
    private var _binding: FragmentEventsBinding? = null
    private val binding get() = _binding!!

    val list = mutableListOf<SelectorMainCard>()
    val adapter = ElementAdapter(list, this)
    private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
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

    override fun onDetach() {
        viewModel.showToolbar()

        super.onDetach()
    }

    override fun onClickEvent(id: String) {
    }

    override fun onClickHabitation(id: String) {
        val bundle = Bundle()
        bundle.putString("playlistId", id)
        findNavController().navigate(R.id.habitationCardFragment, bundle)
    }
}