package com.example.num1.api

import com.example.num1.ResponseRepoInfo
import com.example.num1.ResponseUserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{userId}")
    fun repoForUser(
        @Path("userId") userId:String
    ): Call<List<ResponseRepoInfo>>

    @GET("users/{userId}")
    fun getFollowingInfo(
        @Path("userId") userId:String
    ): Call<List<ResponseUserInfo>>
}



