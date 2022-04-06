package com.example.num1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.num1.databinding.ActivitySiginInBinding
import com.example.num1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.setOnClickListener{

            val name:String = binding.edtName.text.toString()
            val id: String = binding.edtId.text.toString()
            //edtid에 입력된 값을 id에 저장
            val pw: String = binding.edtPassword.text.toString()
            //로그인 버튼을 눌렀을 때 로그인 되도록

            if(id == "" || pw == "" || name ==""){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else{
                finish()
            }


        }
    }
}