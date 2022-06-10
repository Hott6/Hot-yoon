package com.example.num1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.num1.databinding.FragmentOnBoarding2Binding
import com.example.num1.databinding.FragmentOnBoarding3Binding
import com.example.num1.databinding.FragmentProfileBinding
import com.example.num1.view.SignInActivity


class OnBoarding3 : Fragment() {
    private var _binding: FragmentOnBoarding3Binding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoarding3Binding.inflate(layoutInflater, container, false)
        goSignIn()
        return binding.root
    }

    private fun goSignIn(){
        binding.btnNext.setOnClickListener {
            val intent = Intent(context,SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

}