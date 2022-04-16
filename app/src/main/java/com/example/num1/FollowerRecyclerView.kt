package com.example.num1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.num1.databinding.ActivityHomeBinding
import com.example.num1.databinding.FragmentFollowerRecyclerViewBinding

class FollowerRecyclerView : Fragment() {
    private var _binding: FragmentFollowerRecyclerViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerRecyclerViewBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData(R.drawable.maja, "최윤정", "금잔디 YB 마자용"),
                UserData(R.drawable.chco, "최유리", "금잔디 YB 치코리타"),
                UserData(R.drawable.ggogimo, "이준원", "금잔디 YB 꼬지모"),
                UserData(R.drawable.raishu, "김수빈", "금잔디 OB 라이츄"),
                UserData(R.drawable.altoong, "권용민", "금잔디 OB 알통몬")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}