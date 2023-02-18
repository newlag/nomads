package com.hakaton.nomads.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hakaton.nomads.R
import com.hakaton.nomads.databinding.ActivityMainBinding
import com.vk.api.sdk.VKApiCallback
import com.vk.sdk.api.users.dto.UsersUserFull

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)


//        val authLauncher = VK.login(this) { result: VKAuthenticationResult ->
//            when (result) {
//                is VKAuthenticationResult.Success -> {
//                    val list = mutableListOf<UsersFields>()
//                    UsersFields.values().map {
//                        list.add(it)
//                    }
//                    VK.execute(
//                        UsersService().usersGet(
//                            listOf(result.token.userId),
//                            list.subList(0, 64)
//                        ), personDataCallback
//                    )
//                }
//                is VKAuthenticationResult.Failed -> {
//                    // User didn't pass authorization
//                }
//            }
//        }
//        authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))

    }

    private val personDataCallback = object : VKApiCallback<List<UsersUserFull>> {
        override fun fail(error: Exception) {
            Log.i("dwdawd", "$error")
        }

        override fun success(result: List<UsersUserFull>) {
            Log.i("dwdawd", "$result")

        }

    }
}