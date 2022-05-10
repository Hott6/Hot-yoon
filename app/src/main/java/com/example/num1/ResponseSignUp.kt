package com.example.num1

data class ResponseSignUp(  //회원가입 했을 때
    val status: Int,
    val message: String,
    val data: Data
){
    data class Data(
        val id: Int
    )
}
