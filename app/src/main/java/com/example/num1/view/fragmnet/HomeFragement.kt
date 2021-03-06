package com.example.num1.view.fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.num1.databinding.FragmentHomeBinding
import com.example.num1.view.adapter.SampleTabViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragement : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
    private lateinit var sampleTabViewPagerAdapter: SampleTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        initAdapter()
        initRabLayout()

        return binding.root
    }

    private fun initAdapter(){
        val fragmentList = listOf(TabFragmentFollower(), TabFragmentFollowing())

        sampleTabViewPagerAdapter = SampleTabViewPagerAdapter(this)
        sampleTabViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHomefragment.adapter = sampleTabViewPagerAdapter
    }

    private fun initRabLayout(){
        val tabLabel = listOf("팔로잉","팔로워")

        TabLayoutMediator(binding.tabHome, binding.vpHomefragment){tab,position->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}