package com.example.num1

import com.example.num1.api.GithubService
import com.example.num1.api.SoptService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator { //서비스를 생성해주는 구현체 부분
    private const val BASE_URL_SOPT = "http://13.124.62.236/"
    private const val BASE_URL_GIT = "https://api.github.com/"  //바뀌지 않는 부분을 baseurl로 넣어준다

    private val soptRetrofit:Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_SOPT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val githubRetrofit:Retrofit = Retrofit.Builder()    //객체 초기화
        .baseUrl(BASE_URL_GIT)      //서버에 메인 url전달
        .addConverterFactory(GsonConverterFactory.create()) //gson을 우리가 쓰는 언어로 바꿔주는 거
        .build()

    val soptService: SoptService = soptRetrofit.create(SoptService::class.java)
    //interface 객체를 create에 넘겨 실제 구현체 생성, retrofit2는 HTTP API를 자바 인터페이스 형태로 사용하는 라이브러리이기에 .create를 해주는 것임
    val githubService: GithubService = githubRetrofit.create(GithubService::class.java)

}