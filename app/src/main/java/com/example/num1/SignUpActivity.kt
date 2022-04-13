package com.example.num1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.num1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.setOnClickListener{

            if(binding.edtName.text.isEmpty() or binding.edtId.text.isEmpty() or binding.edtPassword.text.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this ,SignInActivity::class.java)
                //signin(도착하는 activity)에 입력한걸 이동 즉, siginActivity로 이동 할 수 있게 해주것
                intent.putExtra("id", binding.edtId.text.toString())
                intent.putExtra("pw",binding.edtPassword.text.toString())
                setResult(Activity.RESULT_OK, intent)
                //이 activity가
                finish()
            }
        }
    }
}