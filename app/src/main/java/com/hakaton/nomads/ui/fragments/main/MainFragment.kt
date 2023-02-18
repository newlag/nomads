package com.hakaton.nomads.ui.fragments.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.hakaton.nomads.data.repositories.*
import com.hakaton.nomads.databinding.FragmentMainBinding
import com.hakaton.nomads.domain.repositories.OrganizationsRepository
import com.hakaton.nomads.domain.repositories.TourismRoomsRepository
import com.hakaton.nomads.ui.MainActivity
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.MainFragmentRecyclerView
import com.hakaton.nomads.ui.fragments.main.adapters.TwoTextDataClass
import com.yandex.metrica.YandexMetrica

class MainFragment : Fragment() {
    var _binding: FragmentMainBinding? = null

    private val roomsRepository: TourismRoomsRepository = TourismRoomsRepositoryImpl()
    private val organizationsRepository: OrganizationsRepository = OrganizationsRepositoryImpl()
    private val tourismTwoRepository: HabitationsRepositoryImpl = HabitationsRepositoryImpl()
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
        organizationsRepository.getData().observe(viewLifecycleOwner) {
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
        binding.recyclerView.adapter =
            MainFragmentRecyclerView(
                listOf(
                    EventMainDataClass(),
                    TwoTextDataClass("", ""),
                    HabitationMainDataClass(),
                    HabitationMainDataClass(),
                    HabitationMainDataClass(),
                    HabitationMainDataClass(),
                    HabitationMainDataClass(),
                    HabitationMainDataClass()
                )
            )
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("MainFragment", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            Toast.makeText(context, "token received", Toast.LENGTH_SHORT).show()
        })
        return binding.root
    }
}