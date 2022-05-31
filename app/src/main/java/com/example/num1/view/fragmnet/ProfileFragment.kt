package com.example.num1.view.fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.bumptech.glide.Glide
import com.example.num1.R
import com.example.num1.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var position = FOLLOWER_FRAGMENT    //이벤트 처리를 위한 변수 선언

    //private lateinit var binding: ProfileFragment  원래 이건데
    private var _binding: FragmentProfileBinding? = null    //fragmnet로 바꿔줬기 떄문에 _binding으로
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        initTransactionEvent()
        changeToFollowerFragment()
        changeToRepositoryFragment()
        initImage()

        return binding.root
    }

    private fun initTransactionEvent() {
        binding.btnFollower.isSelected = true   //처음 선택이 btnfollower로 되어있게끔
        childFragmentManager.commit {
            setReorderingAllowed(true)  //이것도 함께 넣어주는게 좋다고 공식문서가 그랬대요
            add<FollowerFragment>(R.id.fragment_main)
        }

    }

    private fun changeToRepositoryFragment() {
        binding.btnRepo.setOnClickListener {
            binding.btnRepo.isSelected = true
            binding.btnFollower.isSelected = false
            if (position == FOLLOWER_FRAGMENT) {
                childFragmentManager.commit {
                    replaceFragment<RepositoryFragment>(R.id.fragment_main)
                }
                position = REPO_FRAGMENT
            }
        }
    }

    private fun changeToFollowerFragment() {
        binding.btnFollower.setOnClickListener {
            binding.btnRepo.isSelected = false
            binding.btnFollower.isSelected = true
            if (position == REPO_FRAGMENT) {
                childFragmentManager.commit {
                    replaceFragment<FollowerFragment>(R.id.fragment_main)
                }
                position = FOLLOWER_FRAGMENT
            }
        }
    }

    private fun initImage(){
        Glide.with(this)
            .load(R.drawable.maja)
            .circleCrop()
            .into(binding.imageView)
    }

    private inline fun <reified T: Fragment>replaceFragment(pos : Int){
        childFragmentManager.commit{
            setReorderingAllowed(true)
            replace<T>(R.id.fragment_main)
        }
        position = pos
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