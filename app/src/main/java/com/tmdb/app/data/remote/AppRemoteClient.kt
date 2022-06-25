package com.tmdb.app.data.remote

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.krakatio.aplikasiconvertpulsa.data.local.AppPreference
import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.interceptor.Authorization
import com.tmdb.app.data.remote.model.common.Wrapper
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.*
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class AppRemoteClient @Inject constructor(
    @ApplicationContext context: Context,
    private val preference: AppPreference
) {
    companion object {
        const val API_URL = "${BuildConfig.SERVER_URL}/3/"
    }

    private val chucker = ChuckerInterceptor.Builder(context).build()
    private val gson = GsonBuilder().setLenient().create()

    fun <T> create(clazz: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(buildClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(clazz)
    }

    suspend fun <T> execute(call: suspend () -> T): Result<T> {
        return try {
            val response = call()
            Success(data = response)
        } catch (ex: IOException) {
            Timber.e(ex)
            NetworkError()
        } catch (ex: HttpException) {
            Timber.e(ex)
            getHttpErrorResult(ex)
        } catch (ex: Exception) {
            Timber.e(ex)
            Error.construct(ex)
        }
    }

    private fun buildClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.BASIC

        val builder = OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(chucker)
        val userJson = preference.get().getString(AppPreference.KEY_USER, null)
        if (userJson != null) {
            try {
                val user = gson.fromJson(userJson, User::class.java) ?: throw NullPointerException()

                builder.addInterceptor(Authorization(user.token))
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }

        return builder.build()
    }

    private fun <T> getHttpErrorResult(ex: HttpException): Error<T> {
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
        return if (message.isBlank()) Error.general(message)
        else GeneralError(message)
    }
}