package com.example.num1

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.num1.databinding.ActivityHomeBinding
import com.example.num1.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var position = FOLLOWER_FRAGMENT    //이벤트 처리를 위한 변수 선언
    //private lateinit var binding: ProfileFragment  원래 이건데
    private var _binding: FragmentProfileBinding ?= null    //fragmnet로 바꿔줬기 떄문에 _binding으로
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        initTransactionEvent()

        return binding.root
    }

    private fun initTransactionEvent() {

        childFragmentManager.commit {
            add<RepositoryFragment>(R.id.fragment_main)
        }

        binding.btnRepo.setOnClickListener {
            if (position == FOLLOWER_FRAGMENT) {
                childFragmentManager.commit {
                    replace<RepositoryFragment>(R.id.fragment_main)
                }
                position = REPO_FRAGMENT
            }
        }

        binding.btnFollower.setOnClickListener {
            if (position == REPO_FRAGMENT) {
                childFragmentManager.commit {
                    replace<FollowerFragment>(R.id.fragment_main)
                }
                position = FOLLOWER_FRAGMENT
            }
        }
    }

    companion object {
        const val FOLLOWER_FRAGMENT = 1
        const val REPO_FRAGMENT = 2
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}