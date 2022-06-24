package com.tmdb.app.data.local.source

import com.google.gson.Gson
import com.krakatio.aplikasiconvertpulsa.data.local.AppPreference
import com.tmdb.app.domain.datasource.UserDataSource
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.*
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val preference: AppPreference
) : UserDataSource {

    private val gson = Gson()

    override suspend fun getRequestToken(): Result<User?> {
        return try {
            val userJson = preference.get().getString(AppPreference.KEY_USER, null) ?: throw Exception()
            val user = gson.fromJson(userJson, User::class.java) ?: throw Exception()
            Success(user)
        } catch (ex: Exception) {
            ex.printStackTrace()
            AuthError()
        }
    }

    override suspend fun saveRequestToken(user: User) : Result<Unit> {
        return try {
            val userJson = gson.toJson(user) ?: throw Exception()
            val isSaved = preference.editor()
                .putString(AppPreference.KEY_USER, userJson)
                .commit()
            if (isSaved) Success(Unit) else Error.unknown()
        } catch (ex: Exception) {
            ex.printStackTrace()
            Error.construct(ex)
        }
    }

}