package com.example.num1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.num1.databinding.ActivitySiginInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding :ActivitySiginInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySiginInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{

            val id: String = binding.edtId.text.toString()
            //edtid에 입력된 값을 id에 저장
            val pw: String = binding.edtPassword.text.toString()
            //로그인 버튼을 눌렀을 때 로그인 되도록
            val intent = Intent(this,HomeActivity::class.java)

            if(id == "" || pw == "" ){
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        binding.btnSign.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}