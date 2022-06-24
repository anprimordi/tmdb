package com.tmdb.app.data.repository

import com.tmdb.app.di.datasource.LocalDataSource
import com.tmdb.app.di.datasource.RemoteDataSource
import com.tmdb.app.domain.datasource.UserDataSource
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import javax.inject.Inject

class UserRepository @Inject constructor(
    @LocalDataSource private val localDataSource: UserDataSource,
    @RemoteDataSource private val remoteDataSource: UserDataSource
) : UserDataSource {
    override suspend fun getRequestToken(): Result<User?> {
        val localResult = localDataSource.getRequestToken()

        return if (localResult is Success) {
            localResult
        } else {
            val remoteResult = remoteDataSource.getRequestToken()
            if (remoteResult is Success) {
                val localUser = localResult.data
                val remoteUser = remoteResult.data
                if (remoteUser != null) {
                    saveRequestToken(user = remoteUser.copy(token = localUser?.token ?: ""))
                }
                remoteResult
            } else {
                localResult
            }
        }
    }

    override suspend fun saveRequestToken(user: User): Result<Unit> {
        return localDataSource.saveRequestToken(user)
    }

}