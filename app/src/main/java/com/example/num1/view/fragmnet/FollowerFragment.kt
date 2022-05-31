package com.example.num1.view.fragmnet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.num1.util.MyDecoration
import com.example.num1.data.ServiceCreator
import com.example.num1.data.UserData
import com.example.num1.data.github.ResponseUserInfo
import com.example.num1.databinding.FragmentFollowerBinding
import com.example.num1.view.DetailActivity
import com.example.num1.view.adapter.FollowerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        followerNetwork()
        return binding.root
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter
        binding.rvFollower.addItemDecoration(MyDecoration(20, 1))

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

    private fun followerNetwork() {
        val call: Call<List<ResponseUserInfo>> =
            ServiceCreator.githubService.getFollowingInfo("choi")

        call.enqueue(object : Callback<List<ResponseUserInfo>> {
            override fun onResponse(
                call: Call<List<ResponseUserInfo>>,
                response: Response<List<ResponseUserInfo>>
            ) {
                if (response.isSuccessful) {    //불러오는게 성공하면
                    val data = response.body()!!
                    for (i in data.indices) {

                        val login  = data[i].name
                        val introduce = data[i].html_url
                        val imgUrl = data[i].avatar_url
                        followerAdapter.userList.add(UserData(login, introduce,imgUrl ))
                    }
                    followerAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(context, "팔로워 데이터를 불러오지 못했습니다", Toast.LENGTH_SHORT)
                        .show() //머임 여기 왜 context써야됨
                }
            }

            override fun onFailure(call: Call<List<ResponseUserInfo>>, t: Throwable) {
                Log.d("Networkerror", "error:$t")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}