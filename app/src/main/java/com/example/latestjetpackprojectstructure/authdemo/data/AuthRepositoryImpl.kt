package com.example.latestjetpackprojectstructure.authdemo.data

import com.example.latestjetpackprojectstructure.authdemo.data.remote.ApiService
import com.example.latestjetpackprojectstructure.authdemo.data.remote.dto.LoginResponse
import com.example.latestjetpackprojectstructure.authdemo.data.remote.dto.RegisterResponse

class AuthRepositoryImpl : ApiService {
    override suspend fun login(): LoginResponse {
        TODO("Not yet implemented")
    }

    override suspend fun register(): RegisterResponse {
        TODO("Not yet implemented")
    }
}