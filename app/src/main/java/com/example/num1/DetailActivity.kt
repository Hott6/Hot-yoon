package com.example.num1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.num1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        binding.imgDetailProfile.setImageResource(intent.getIntExtra("image",-1))
        //getIntExtra(이름,원하는 유형의 값이 지정된 이름으로 저장되지 않은 경우 반환되는 값)
        binding.tvDetailName.text = intent.getStringExtra("name")   //문자열이여서 get"string"
        binding.tvDetailIntroduce.text = intent.getStringExtra("introduce")
        setContentView(binding.root)
    }
}