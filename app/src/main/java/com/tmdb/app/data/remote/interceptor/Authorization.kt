package com.tmdb.app.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class Authorization(private val token: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .header(name = "Authorization", value = "Bearer $token")
                .build()
        )
    }

}