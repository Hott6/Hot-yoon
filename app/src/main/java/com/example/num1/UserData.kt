package com.example.num1

data class UserData(
    var image: Int, //사진 다 다르게 받아오는거 어떻게 하눈고쥡?
    val name: String,
    val introduction: String
)

data class repoData(
    val repotitle: String,
    val reposource: String
)