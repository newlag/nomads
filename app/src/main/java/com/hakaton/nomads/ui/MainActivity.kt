package com.hakaton.nomads.ui

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hakaton.nomads.R
import com.hakaton.nomads.data.repositories.local.login.LoginSharadPr
import com.hakaton.nomads.databinding.ActivityMainBinding
import com.hakaton.nomads.ui.fragments.profile.AuthCallBack
import com.hakaton.nomads.utils.GlideWrapper
import com.hakaton.nomads.utils.ToolbarViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.utils.VKUtils
import com.vk.sdk.api.users.UsersService
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.users.dto.UsersUserFull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var authLauncher: ActivityResultLauncher<Collection<VKScope>>

    lateinit var authCallBack: AuthCallBack
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this)[ToolbarViewModel::class.java]
        viewModel.getStateFlow().onEach {
            if (it) {
                binding.toolBarMain.visibility = View.VISIBLE
            } else {
                binding.toolBarMain.visibility = View.GONE
            }
        }.launchIn(lifecycleScope)

        setContentView(binding.root)

        GlideWrapper(baseContext).loadImageNoCash(
            binding.imageViewProfile,
            LoginSharadPr().getPhotoUri(baseContext)
        )

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_main -> {
                    navView.visibility = View.VISIBLE

                }
                R.id.navigation_favorite -> {
                    navView.visibility = View.VISIBLE
                }

                R.id.navigation_info -> {
                    navView.visibility = View.VISIBLE
                }
                else -> {
                    navView.visibility = View.GONE
                }
            }
        }
        binding.imageViewProfile.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
        authLauncher = VK.login(this) { result: VKAuthenticationResult ->
            when (result) {
                is VKAuthenticationResult.Success -> {
                    var list = mutableListOf(
                        UsersFields.LAST_NAME_ABL,
                        UsersFields.PHOTO_400_ORIG,
                        UsersFields.EDUCATION
                    )
                    LoginSharadPr().setLoginId(this, result.token.userId.value)
                    VK.execute(UsersService().usersGet(
                        listOf(result.token.userId), list
                    ), object : VKApiCallback<List<UsersUserFull>> {
                        override fun fail(error: Exception) {
                            authCallBack.onError()
                        }

                        override fun success(result: List<UsersUserFull>) {
                            authCallBack.onSuccess(result[0])
                            GlideWrapper(baseContext).loadImageNoCash(
                                binding.imageViewProfile,
                                LoginSharadPr().getPhotoUri(baseContext)
                            )
                        }

                    })
                }
                is VKAuthenticationResult.Failed -> {
                    authCallBack.onError()
                }
            }
        }
    }

    fun auth(authCallBack: AuthCallBack) {
        this.authCallBack = authCallBack
        authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
    }
}