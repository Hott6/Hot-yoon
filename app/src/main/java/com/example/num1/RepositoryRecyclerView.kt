package com.example.num1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.num1.databinding.FragmentFollowerRecyclerViewBinding
import com.example.num1.databinding.FragmentRepositoryRecyclerViewBinding

class RepositoryRecyclerView : Fragment() {
    private var _binding: FragmentRepositoryRecyclerViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var rePositoryAdapter: RePositoryAdapter

    private fun initAdapter() {
        rePositoryAdapter = RePositoryAdapter()
        binding.rvRepository.adapter = rePositoryAdapter

        rePositoryAdapter.repoList.addAll(
            listOf(
                repoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                repoData("IOS 과제 레포지토리", "ios 파트 과제"),
                repoData("서버 과제 레포지토리", "서버 파트 과제"),
                repoData("기획 과제 레포지토리", "기획 파트 과제"),
                repoData("다자인 과제 레포지토리", "디자인 파트 과제")
            )
        )
        rePositoryAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryRecyclerViewBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}