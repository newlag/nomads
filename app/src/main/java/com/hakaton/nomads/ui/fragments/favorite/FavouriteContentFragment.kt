package com.hakaton.nomads.ui.fragments.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.R
import com.hakaton.nomads.data.repositories.EventsRepositoryImpl
import com.hakaton.nomads.data.repositories.HabitationsRepositoryImpl
import com.hakaton.nomads.data.repositories.local.SingletonData
import com.hakaton.nomads.databinding.FragmentFavouriteContentBinding
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.*
import kotlinx.coroutines.flow.*

class FavouriteContentFragment : Fragment(), MainRecyclerClickListener {
    private lateinit var binding: FragmentFavouriteContentBinding
    private val list = mutableListOf<SelectorMainCard>()
    private val adapter = MainFragmentRecyclerView(isFavourite = true, list = list, click = this)
    private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()
    private val tourismTwoRepository: HabitationsRepositoryImpl = HabitationsRepositoryImpl()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteContentBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        tourismTwoRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0).combine(
            eventsRepository.getData().shareIn(lifecycleScope, SharingStarted.Eagerly, 0)
        ) { tourism, event ->
            if (tourism != null && event != null) {
                SingletonData.getInstance().habitationstList.clear()
                SingletonData.getInstance().habitationstList.addAll(tourism.toList())
                SingletonData.getInstance().eventList.clear()
                SingletonData.getInstance().eventList.addAll(event.toList())

                val newList: ArrayList<SelectorMainCard> = ArrayList()
                newList.add(HabitationMainDataClass(tourism.subList(0, 10)))
                newList.add(TwoTextDataClass("", ""))
                event.subList(0, 10).map {
                    newList.add(EventMainDataClass(it))
                }
                val newNewList: ArrayList<SelectorMainCard> = ArrayList()
                var isFirstComplete = false
                newList.forEach { it ->
                    when (it) {
                        is HabitationMainDataClass -> {
                            it.habitations.forEach {
                                if (!isFirstComplete) {
                                    newNewList.add(HabitationFavHeaderDataClass(it))
                                    isFirstComplete = true
                                } else {
                                    newNewList.add(HabitationFavDataClass(it))
                                }
                            }
                        }
                        else -> {
                            newNewList.add(it)
                        }
                    }
                }
                list.clear()
                list.addAll(newNewList)
            }
        }.onEach {
            adapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)
        return binding.root
    }



    override fun onClickEvent(id: String) {
        findNavController().navigate(R.id.eventsFragment)

    }

    override fun onClickHabitation(id: String) {
        findNavController().navigate(R.id.habitationFragment)

    }
}