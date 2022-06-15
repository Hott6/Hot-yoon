package com.example.num1.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.num1.R
import com.example.num1.databinding.FragmentOnBoarding2Binding

class OnBoarding2 : Fragment() {

    private var _binding: FragmentOnBoarding2Binding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoarding2Binding.inflate(layoutInflater, container, false)
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding2_to_onBoarding3)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

