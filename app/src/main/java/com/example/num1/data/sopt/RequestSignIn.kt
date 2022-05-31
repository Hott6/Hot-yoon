package com.example.num1

import com.google.gson.annotations.SerializedName

data class RequestSignIn(
    @SerializedName("email")
    val id: String,
    val password: String
)
