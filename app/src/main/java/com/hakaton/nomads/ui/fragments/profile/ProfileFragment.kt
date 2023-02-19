package com.hakaton.nomads.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.hakaton.nomads.data.repositories.local.login.LoginSharadPr
import com.hakaton.nomads.data.repositories.local.login.PersonalData
import com.hakaton.nomads.databinding.FragmentProfileBinding
import com.hakaton.nomads.ui.MainActivity
import com.hakaton.nomads.ui.fragments.BaseSecondaryFragment
import com.hakaton.nomads.utils.GlideWrapper
import com.vk.api.sdk.VK
import com.vk.sdk.api.users.dto.UsersUserFull

class ProfileFragment : BaseSecondaryFragment(), AuthCallBack {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (LoginSharadPr().isLogin(requireContext())) {
            authSuccess(LoginSharadPr().getFull(requireContext()))
        } else {
            binding.constraintLayoutUnLoginContainer.visibility = View.VISIBLE
            activateLoginButton()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun activateLoginButton() {
        binding.buttonLogin.setOnClickListener {
            (requireActivity() as MainActivity).auth(this)
        }
    }

    override fun onSuccess(result: UsersUserFull) {
        val fio =
            (result.lastName ?: "") + " " + (result.firstName ?: " Не удалось получить ваше ФИО")
        val data = PersonalData(
            fio, result.photo400Orig ?: "",
            result.universityName ?: ""
        )
        LoginSharadPr().setLogin(
            requireContext(),
            data
        )
        Toast.makeText(requireContext(), "Авторизация прошла успешно", Toast.LENGTH_LONG).show()
        authSuccess(data)
    }

    private fun authSuccess(data: PersonalData) {
        binding.constraintLayoutUnLoginContainer.visibility = View.GONE
        binding.imageViewLogout.visibility = View.VISIBLE
        binding.constraintLayoutLoginContainer.visibility = View.VISIBLE
        binding.textViewFio.text = data.fio
        GlideWrapper(requireContext()).loadImage(binding.imageViewPhoto, data.photoUri)
        binding.textViewUniversity.text = data.university
        binding.imageViewLogout.setOnClickListener {
            LoginSharadPr().logOut(requireContext())
            VK.logout()
            findNavController().popBackStack()
        }
    }

    override fun onError() {
        Toast.makeText(
            requireContext(),
            "Авторизация прошла не успешно",
            Toast.LENGTH_LONG
        ).show()
    }


}