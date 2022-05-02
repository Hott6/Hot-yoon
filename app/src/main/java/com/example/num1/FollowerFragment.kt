package com.example.num1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.num1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.")

    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter
        binding.rvFollower.addItemDecoration(MyDecoration(20, 1))
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
        //notifyDatasetChanged()는 recyclerview에 표현할 데이터를 업데이트하기 위해 주로 사용함

        //클릭리스너 등록
        followerAdapter.setItemClickListener(object : FollowerAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                val image = followerAdapter.userList[position].image
                val name = followerAdapter.userList[position].name
                val introduce = followerAdapter.userList[position].introduction

                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("image", image)
                    putExtra("name", name)
                    putExtra("introduce", introduce)
                }
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
