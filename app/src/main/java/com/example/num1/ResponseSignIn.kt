package com.example.num1


data class ResponseSignIn(
    val status: Int,
    val message: String,
    val data: Data
){
    data class Data(
        val name: String,
        val email: String
    )
}
