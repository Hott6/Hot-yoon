package com.example.num1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.num1.databinding.ActivityHomeBinding
import com.example.num1.databinding.ActivitySiginInBinding

class HomeActivity : AppCompatActivity() {
    private var position = FOLLOWER_FRAGMENT
    //이벤트 처리를 위한 변수 선언

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        val fragment1 = FollowerRecyclerView()
        val fragment2 = RepositoryRecyclerView()

        supportFragmentManager.beginTransaction().add(R.id.fragment_main, fragment1).commit()

        binding.btnRepo.setOnClickListener {
            if (position == FOLLOWER_FRAGMENT) {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_main, fragment2)
                    .commit()
                position = REPO_FRAGMENT
            }
        }

        binding.btnFollower.setOnClickListener {
            if (position == REPO_FRAGMENT) {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_main, fragment1)
                    .commit()
                position = FOLLOWER_FRAGMENT
            }
        }
    }

    companion object {
        const val FOLLOWER_FRAGMENT = 1
        const val REPO_FRAGMENT = 2
    }
}