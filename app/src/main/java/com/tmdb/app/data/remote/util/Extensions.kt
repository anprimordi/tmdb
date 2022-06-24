package com.tmdb.app.data.remote.util

import com.google.gson.Gson
import com.tmdb.app.data.remote.model.common.Wrapper
import com.tmdb.app.domain.model.common.Error.Companion.construct
import com.tmdb.app.domain.model.common.Error.Companion.general
import com.tmdb.app.domain.model.common.GeneralError
import com.tmdb.app.domain.model.common.NetworkError
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

suspend fun <T> execute(call: suspend () -> T): Result<T> {
    return try {
        val response = call()
        Success(data = response)
    } catch (ex: IOException) {
        Timber.e(ex)
        NetworkError()
    } catch (ex: HttpException) {
        Timber.e(ex)
        val errorBody = ex.response()?.errorBody()
        val response = if (errorBody != null) {
            val gson = Gson()
            try {
                gson.fromJson(errorBody.charStream(), Wrapper::class.java)
            } catch (ex: Exception) {
                null
            }
        } else null

        val message = response?.message ?: ex.message()
        if (message.isBlank()) general("Code ${ex.code()}")
        else GeneralError(message)
    } catch (ex: Exception) {
        Timber.e(ex)
        construct(ex)
    }
}