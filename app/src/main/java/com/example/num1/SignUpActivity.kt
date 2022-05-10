package com.example.num1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.num1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSignUpCompleteButton()

    }

    fun initSignUpCompleteButton() {
        binding.btnSign.setOnClickListener {
            signupNetwork()
            if (binding.edtName.text.isEmpty() or binding.edtId.text.isEmpty() or binding.edtPassword.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                //signin(도착하는 activity)에 입력한걸 이동 즉, siginActivity로 이동 할 수 있게 해주것
                intent.putExtra(
                    "id",
                    binding.edtId.text.toString()
                )    //signup edt_id에 있는것을 signin에 넣어준다
                intent.putExtra("pw", binding.edtPassword.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun signupNetwork() {
        val requestSignUp = RequestSignUp(
            id = binding.edtId.text.toString(),
            name = binding.edtName.text.toString(),
            password = binding.edtPassword.text.toString()
        )

        val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(requestSignUp)

        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignUpActivity,"${data?.id}회원가입에 성공했습니다.",Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT)
                    .show()
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}