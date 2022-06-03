package com.example.num1.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.num1.RequestSignIn
import com.example.num1.ResponseSignIn
import com.example.num1.ServiceCreator
import com.example.num1.databinding.ActivitySiginInBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySiginInBinding

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == Activity.RESULT_OK) {    //resultcode : 인텐트로 실행된 곳에서 돌려받은 결과 코드
                val data: Intent? = result.data        //data : 결과 데이터가 들어있는 인텐트 객체
                val userId = data?.getStringExtra("id") //signup에서 넣어준걸 get으로 받아준다.
                val userPw = data?.getStringExtra("pw")
                binding.edtId.setText(userId)
                binding.edtPassword.setText(userPw)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySiginInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
        signUp()

    }

    private fun login() {
        binding.btnLogin.setOnClickListener {
            if (binding.edtId.text.isEmpty() or binding.edtPassword.text.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                loginNetwork()
            }
        }
    }

    private fun signUp() {
        binding.btnSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun loginNetwork() {
        val requestSignIn = RequestSignIn(
            id = binding.edtId.text.toString(),
            password = binding.edtPassword.text.toString()
        )

        val call: Call<ResponseSignIn> = ServiceCreator.soptService.postLogin(requestSignIn)

        call.enqueue(object : Callback<ResponseSignIn> {
            override fun onResponse(
                call: Call<ResponseSignIn>,
                response: Response<ResponseSignIn>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                    if (!isFinishing){
                        finish()
                    }
                } else Toast.makeText(this@SignInActivity, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}
