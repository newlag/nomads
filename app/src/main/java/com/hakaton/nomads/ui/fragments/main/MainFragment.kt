package com.hakaton.nomads.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.hakaton.nomads.R
import com.hakaton.nomads.data.repositories.*
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentMainBinding
import com.hakaton.nomads.domain.repositories.OrganizationsRepository
import com.hakaton.nomads.domain.repositories.TourismRoomsRepository
import com.hakaton.nomads.ui.fragments.BaseMainFragment
import com.hakaton.nomads.ui.fragments.main.adapters.*
import kotlinx.coroutines.flow.*

class MainFragment : BaseMainFragment(), MainRecyclerClickListener {
    var _binding: FragmentMainBinding? = null

    private val roomsRepository: TourismRoomsRepository = TourismRoomsRepositoryImpl()
    private val organizationsRepository: OrganizationsRepository = OrganizationsRepositoryImpl()
    private val tourismTwoRepository: HabitationsRepositoryImpl = HabitationsRepositoryImpl()
    private val laboratoriesRepository: LaboratoriesRepositoryImpl = LaboratoriesRepositoryImpl()
    private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()

    val binding get() = _binding!!
    val list = mutableListOf<SelectorMainCard>()
    val adapter = MainFragmentRecyclerView(list = list, click = this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter =
            adapter
        val eventList = SingletonData.getInstance().eventList
        val habitationsList = SingletonData.getInstance().habitationstList
        if (eventList.isEmpty() && habitationsList.isEmpty()) {
            binding.progressBar.visibility = View.VISIBLE
            requestData()
        } else {
            list.clear()
            list.add(HabitationMainDataClass(habitationsList.subList(0, 10)))
            list.add(TwoTextDataClass("", ""))
            eventList.subList(0, 10).map {
                list.add(EventMainDataClass(it))
            }
            adapter.notifyDataSetChanged()
        }


        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("MainFragment", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            // Get new FCM registration token
        })
        return binding.root
    }

    private fun requestData() {
        tourismTwoRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0).combine(
            eventsRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0)
        ) { tourism, event ->
            if (tourism != null && event != null) {
                SingletonData.getInstance().habitationstList.clear()
                SingletonData.getInstance().habitationstList.addAll(tourism.toList())
                SingletonData.getInstance().eventList.clear()
                SingletonData.getInstance().eventList.addAll(event.toList())
                list.clear()
                list.add(HabitationMainDataClass(tourism.subList(0, 10)))
                list.add(TwoTextDataClass("", ""))
                event.subList(0, 10).map {
                    list.add(EventMainDataClass(it))
                }
            }
        }.onEach {
            binding.progressBar.visibility = View.GONE
            adapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)
    }


    override fun onClickEvent(id: String) {
        findNavController().navigate(R.id.eventsFragment)
    }

    override fun onClickHabitation(id: String) {
        findNavController().navigate(R.id.habitationFragment)
    }
}