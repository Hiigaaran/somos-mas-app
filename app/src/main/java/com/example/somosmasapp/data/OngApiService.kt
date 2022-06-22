package com.example.somosmasapp.data

import com.example.somosmasapp.data.dto.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OngApiService {

    @POST("/api/register")
    fun doRegister(@Body body: Register): Call<RepositoryResponse<UserRegister>>

    @POST("/api/login")
    fun doLogin(@Body body: Login): Call<RepositoryResponse<UserRegister>>

    @GET("/api/news")
    fun getNews(): Call<RepositoryResponse<List<News>>>

}