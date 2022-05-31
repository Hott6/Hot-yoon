package com.example.num1.data.sopt

import com.google.gson.annotations.SerializedName

data class RequestSignUp(
    val name: String,
    @SerializedName("email")
    val id: String,
    val password: String
)
