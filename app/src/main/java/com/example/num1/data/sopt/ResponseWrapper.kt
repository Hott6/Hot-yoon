package com.example.num1.data.sopt

data class ResponseWrapper<T>(
    // Response Data의 해당 중복 내용
    val status: Int,
    val message: String,
    val data: T?
)
