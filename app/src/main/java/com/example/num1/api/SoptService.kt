package com.example.num1.api

import com.example.num1.data.sopt.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService { //서버로부터 받아오는
    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseWrapper<ResponseSignIn>>

    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseWrapper<ResponseSignUp>>

}