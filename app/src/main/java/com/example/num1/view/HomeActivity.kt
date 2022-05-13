package com.example.num1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.num1.*
import com.example.num1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var HomeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragement(), CameraFragment())
        HomeViewPagerAdapter = HomeViewPagerAdapter(this)
        HomeViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpMain.adapter = HomeViewPagerAdapter

    }

    private fun initBottomNavi() {
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bvnMain.menu.getItem(position).isChecked = true
            }
        })
        binding.bvnMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_person -> {
                    binding.vpMain.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpMain.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else ->{
                    binding.vpMain.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object{
        const val FIRST_FRAGMENT =0
        const val SECOND_FRAGMENT =1
        const val THIRD_FRAGMENT =2
    }
}