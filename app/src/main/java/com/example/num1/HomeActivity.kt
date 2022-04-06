package com.example.num1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.num1.databinding.ActivitySiginInBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySiginInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}