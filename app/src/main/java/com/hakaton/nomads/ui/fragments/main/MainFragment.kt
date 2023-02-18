package com.hakaton.nomads.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakaton.nomads.data.repositories.*
import com.hakaton.nomads.data.repositories.remote.laboratories.LaboratoriesRequest
import com.hakaton.nomads.databinding.FragmentMainBinding
import com.hakaton.nomads.domain.repositories.TourismOneRepository
import com.hakaton.nomads.domain.repositories.TourismRoomsRepository

class MainFragment : Fragment() {
    var _binding: FragmentMainBinding? = null

    private val roomsRepository: TourismRoomsRepository = TourismRoomsRepositoryImpl()
    private val tourismOneRepository: TourismOneRepository = TourismOneRepositoryImpl()
    private val tourismTwoRepository: TourismTwoRepositoryImpl = TourismTwoRepositoryImpl()
    private val laboratoriesRepository: LaboratoriesRepositoryImpl = LaboratoriesRepositoryImpl()
    private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()

    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        roomsRepository.getData().observe(viewLifecycleOwner) {
            it?.let {
                Log.d("MainFragment", "Получен список Rooms с размером ${it.size}")
            } ?: run {
                Log.d("MainFragment", "Ошибка получения Rooms")
            }
        }
        tourismOneRepository.getData().observe(viewLifecycleOwner) {
            it?.let {
                Log.d("MainFragment", "Получен список Tourism One с размером ${it.size}")
            } ?: run {
                Log.d("MainFragment", "Ошибка получения Tourism One")
            }
        }
        tourismTwoRepository.getData().observe(viewLifecycleOwner) {
            it?.let {
                Log.d("MainFragment", "Получен список Tourism Two с размером ${it.size}")
            } ?: run {
                Log.d("MainFragment", "Ошибка получения Tourism Two")
            }
        }
        laboratoriesRepository.getData().observe(viewLifecycleOwner) {
            it?.let {
                Log.d("MainFragment", "Получен список Laboratories с размером ${it.size}")
            } ?: run {
                Log.d("MainFragment", "Ошибка получения Laboratories")
            }
        }
        eventsRepository.getData().observe(viewLifecycleOwner) {
            it?.let {
                Log.d("MainFragment", "Получен список Events с размером ${it.size}")
            } ?: run {
                Log.d("MainFragment", "Ошибка получения Events")
            }
        }
        return binding.root
    }
}