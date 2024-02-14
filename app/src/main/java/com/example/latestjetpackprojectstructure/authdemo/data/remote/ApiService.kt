package com.example.latestjetpackprojectstructure.authdemo.data.remote

import com.example.latestjetpackprojectstructure.authdemo.data.remote.dto.LoginResponse
import com.example.latestjetpackprojectstructure.authdemo.data.remote.dto.RegisterResponse
import retrofit2.http.POST

interface ApiService {
    companion object {
        //   const val IMAGE_URL = "https://image.tmdb.org/t/p/original/"
        const val BASE_URL = "http://localhost:3000/"
    }

    @POST("login")
    suspend fun login(): LoginResponse

    @POST("register")
    suspend fun register(): RegisterResponse
}