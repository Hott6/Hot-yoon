package com.example.num1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.num1.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {
    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var rePositoryAdapter: RePositoryAdapter

    private fun initAdapter() {
        rePositoryAdapter = RePositoryAdapter()
        binding.rvRepository.adapter = rePositoryAdapter
        binding.rvRepository.addItemDecoration(MyDecoration(10,2))

        rePositoryAdapter.repoList.addAll(
            listOf(
                repoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                repoData("IOS 과제 레포지토리", "아이오 파트 과제"),
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
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}