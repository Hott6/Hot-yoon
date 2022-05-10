package com.example.num1

data class ResponseSignIn(  //로그인 했을 때
    val status: Int,
    val message: String,
    val data: Data
){
    data class Data(
        val name: String,
        val email: String
    )
}
