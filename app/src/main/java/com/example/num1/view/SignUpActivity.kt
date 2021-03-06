package com.example.num1.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.num1.RequestSignUp
import com.example.num1.ResponseSignUp
import com.example.num1.ServiceCreator
import com.example.num1.api.SoptService
import com.example.num1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickEvent()
    }

    private fun clickEvent() {
        with(binding) {
            btnSign.setOnClickListener {
                val etName = edtName.text.toString()
                val etId = edtId.text.toString()
                val etPw = edtPassword.text.toString()

                if (etName.isEmpty() or etId.isEmpty() or etPw.isEmpty()) {
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    signupNetwork()
                }
            }
        }
    }

    private fun passingIntent(edId: String, edPw: String) {
        val intent = Intent(this, SignInActivity::class.java)
        //signin(도착하는 activity)에 입력한걸 이동 즉, siginActivity로 이동 할 수 있게 해주것
        intent.putExtra("id", edId)    //signup edt_id에 있는것을 signin에 넣어준다
        intent.putExtra("pw", edPw)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun signupNetwork() {
        val requestSignUp = RequestSignUp(
            name = binding.edtName.text.toString(),
            id = binding.edtId.text.toString(),
            password = binding.edtPassword.text.toString()
        )
        val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(requestSignUp)

        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data    //body가 null이 아니야? 그러면 data가져왓!
                    Toast.makeText(
                        this@SignUpActivity,
                        "${requestSignUp.name} 님 회원가입에 성공했습니다.",  //이거 ${requestSignup.name}이거 잘 쓴거 맞나?! 알려줘라 수빈!
                        Toast.LENGTH_SHORT
                    ).show()
                    passingIntent(
                        requestSignUp.id,
                        requestSignUp.password
                    ) //서버에서 받아온 애들을 전달 해주야 되니까 request!
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {  //서버 연결이 안됐을 경우
                Log.e("NetworkTest", "error:$t")
            }
        })

    }
}
