package com.example.num1.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.num1.R
import com.example.num1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFollowerInfo()
    }

    private fun getFollowerInfo() {
        with(binding) {
            tvDetailName.text = intent.getStringExtra("name")   //문자열이여서 get"string"
            tvDetailIntroduce.text = intent.getStringExtra("introduce")
            val image = intent.getStringExtra("image")
            Glide.with(this@DetailActivity)
                .load(image)
                .circleCrop()
                .into(binding.imgDetailProfile)
        }
    }

}