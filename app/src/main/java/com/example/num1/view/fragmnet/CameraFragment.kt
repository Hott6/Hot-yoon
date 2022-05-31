package com.example.num1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.num1.databinding.FragmentHomeBinding


class CameraFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}