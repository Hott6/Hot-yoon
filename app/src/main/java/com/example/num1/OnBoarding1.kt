package com.example.num1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.num1.databinding.FragmentHomeBinding
import com.example.num1.databinding.FragmentOnBoarding1Binding

class OnBoarding1 : Fragment() {

    private var _binding : FragmentOnBoarding1Binding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoarding1Binding.inflate(layoutInflater, container, false)
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding1_to_onBoarding2)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
