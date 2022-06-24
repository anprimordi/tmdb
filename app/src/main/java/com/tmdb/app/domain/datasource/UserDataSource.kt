package com.tmdb.app.domain.datasource

import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.Result

interface UserDataSource {
    suspend fun getRequestToken(): Result<User?>
    suspend fun saveRequestToken(user: User): Result<Unit>
}