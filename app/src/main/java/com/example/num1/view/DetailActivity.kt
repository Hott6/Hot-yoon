package com.example.num1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.num1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFollowerInfo()
    }

    private fun getFollowerInfo(){
        with(binding){
            tvDetailName.text = intent.getStringExtra("name")   //문자열이여서 get"string"
            tvDetailIntroduce.text = intent.getStringExtra("introduce")
            Glide.with(binding.root)
                .load(intent.getStringExtra("profile"))
                .circleCrop()
                .into(binding.imgDetailProfile)
        }
    }

}