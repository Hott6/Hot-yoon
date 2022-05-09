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
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.")
    //_binding!! 은 절대로 null이 아니라는 확신이 있을때만 사용하는게 좋다 그래서 _binding?:어쩌구로 사용하는 것이다.

    private lateinit var rePositoryAdapter: RePositoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        rePositoryAdapter = RePositoryAdapter()
        binding.rvRepository.adapter = rePositoryAdapter
        binding.rvRepository.addItemDecoration(MyDecoration(10,2))

        rePositoryAdapter.repoList.addAll(
            listOf(
                RepoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                RepoData("IOS 과제 레포지토리", "아이오 파트 과제"),
                RepoData("서버 과제 레포지토리", "서버 파트 과제"),
                RepoData("기획 과제 레포지토리", "기획 파트 과제"),
                RepoData("다자인 과제 레포지토리", "디자인 파트 과제")
            )
        )
        rePositoryAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}