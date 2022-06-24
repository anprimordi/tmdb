package com.tmdb.app.data.remote.service

import com.tmdb.app.data.remote.model.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserServices {

    @GET(value = "/authentication/token/new")
    suspend fun getRequestToken(
        @Query(value = "api_key") apiKey: String
    ): UserResponse
}