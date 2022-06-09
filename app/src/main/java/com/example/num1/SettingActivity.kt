package com.example.num1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.num1.databinding.ActivitySettingBinding
import com.example.num1.util.LOGINSharedPreferences
import com.example.num1.view.SignInActivity

class SettingActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logout()
    }

    private fun logout(){
        binding.btnLogout.setOnClickListener {
            LOGINSharedPreferences.setLogin(this)
            Toast.makeText(this, "자동로그인이 해제되었습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

}