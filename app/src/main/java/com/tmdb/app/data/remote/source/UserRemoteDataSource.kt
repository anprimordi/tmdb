package com.tmdb.app.data.remote.source

import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.service.UserServices
import com.tmdb.app.data.remote.util.execute
import com.tmdb.app.domain.datasource.UserDataSource
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import com.tmdb.app.domain.model.common.UnsupportedError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userServices: UserServices
) : UserDataSource {
    override suspend fun getRequestToken(): Result<User?> {
//        return Success(User(token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZGE1NTZkMDg0ZDYwNmQ4YmE3ZDExNDBjN2M5YTY5YSIsInN1YiI6IjYyYjQxNTgzNTNmODMzMGQwNzIyMDcxYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uK8IGFFcvva7bHKqWgd1xP5TwaOUGyzXx21DTYSl5Ic"))
        return withContext(Dispatchers.IO) {
            execute {
                val apiKey = BuildConfig.API_KEY
                userServices.getRequestToken(apiKey)
            } map {
                if (it != null) it.toDomain()
                else null
            }
        }
    }

    override suspend fun saveRequestToken(user: User): Result<Unit> {
        return UnsupportedError(this)
    }
}