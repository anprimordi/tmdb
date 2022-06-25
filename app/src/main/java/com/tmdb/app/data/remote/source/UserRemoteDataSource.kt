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
        return withContext(Dispatchers.IO) {
            execute {
                userServices.getRequestToken()
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