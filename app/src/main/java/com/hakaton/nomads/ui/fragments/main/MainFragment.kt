package com.hakaton.nomads.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hakaton.nomads.data.repositories.*
import com.hakaton.nomads.databinding.FragmentMainBinding
import com.hakaton.nomads.domain.repositories.OrganizationsRepository
import com.hakaton.nomads.domain.repositories.TourismRoomsRepository
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.MainFragmentRecyclerView
import com.hakaton.nomads.ui.fragments.main.adapters.TwoTextDataClass
import kotlinx.coroutines.flow.*

class MainFragment : Fragment() {
    var _binding: FragmentMainBinding? = null

    private val roomsRepository: TourismRoomsRepository = TourismRoomsRepositoryImpl()
    private val organizationsRepository: OrganizationsRepository = OrganizationsRepositoryImpl()
    private val tourismTwoRepository: HabitationsRepositoryImpl = HabitationsRepositoryImpl()
    private val laboratoriesRepository: LaboratoriesRepositoryImpl = LaboratoriesRepositoryImpl()
    private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()

    val binding get() = _binding!!
    val list = mutableListOf(
        TwoTextDataClass("", ""),
        EventMainDataClass(),
        EventMainDataClass(),
        EventMainDataClass(),
        EventMainDataClass(),
    )
    val adapter = MainFragmentRecyclerView(list)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter =
            adapter

//        roomsRepository.getData().observe(viewLifecycleOwner) {
//            it?.let {
//                Log.d("MainFragment", "Получен список Rooms с размером ${it.size}")
//            } ?: run {
//                Log.d("MainFragment", "Ошибка получения Rooms")
//            }
//        }
//        organizationsRepository.getData().observe(viewLifecycleOwner) {
//            it?.let {
//                Log.d("MainFragment", "Получен список Org с размером ${it.size}")
//            } ?: run {
//                Log.d("MainFragment", "Ошибка получения Org One")
//            }
//        }
        tourismTwoRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0).combine(
            eventsRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0)
        ) { tourism, event ->
            if (tourism != null || event != null) {
                list.clear()
                list.add(HabitationMainDataClass(tourism!!))
                list.add(TwoTextDataClass("", ""))
                event?.map {
                    list.add(EventMainDataClass(it))
                }
            }
        }.onEach {
            adapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)

        return binding.root
    }
}