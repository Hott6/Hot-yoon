package com.example.num1.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.num1.data.sopt.RequestSignIn
import com.example.num1.data.sopt.ResponseSignIn
import com.example.num1.data.ServiceCreator
import com.example.num1.data.sopt.ResponseWrapper
import com.example.num1.databinding.ActivitySiginInBinding
import com.example.num1.util.LOGINSharedPreferences
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySiginInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySiginInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
        signUp()
        initClickEvent()
        isAutoLogin()

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

    private fun signUp() {
        binding.btnSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    fun <ResponseType> Call<ResponseType>.enqueueUtil(
        onSuccess: (ResponseType) -> Unit,
        onError: ((stateCode: Int) -> Unit)? = null
    ) {
        this.enqueue(object : Callback<ResponseType> {
            override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
                if (response.isSuccessful) {
                    onSuccess.invoke(response.body() ?: return)
                } else {
                    onError?.invoke(response.code())
                }
            }

            override fun onFailure(call: Call<ResponseType>, t: Throwable) {
                Log.d("NetworkTest", "error: $t")
            }
        })
    }

    private fun loginNetwork() {
        val requestSignIn = RequestSignIn(
            id = binding.edtId.text.toString(),
            password = binding.edtPassword.text.toString()
        )
        val call: Call<ResponseWrapper<ResponseSignIn>> =
            ServiceCreator.soptService.postLogin(requestSignIn)

        call.enqueueUtil(
            onSuccess = {
                val data = it.data
                Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                finish()
            },
            onError = {
                Toast.makeText(this@SignInActivity, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT)
                    .show()
            }
        )
    }

    private fun initClickEvent() {
        binding.btnAutoLogin.setOnClickListener {
            binding.btnAutoLogin.isSelected = !binding.btnAutoLogin.isSelected
            LOGINSharedPreferences.setAutoLogin(this, binding.btnAutoLogin.isSelected)
        }
    }

    private fun isAutoLogin() {
        if (LOGINSharedPreferences.getAutoLogin(this)) {
            Toast.makeText(this, "자동로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }


}