package com.example.num1.api

import com.example.num1.RequestSignIn
import com.example.num1.RequestSignUp
import com.example.num1.ResponseSignIn
import com.example.num1.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService { //서버로부터 받아오는
    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>

    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>

}