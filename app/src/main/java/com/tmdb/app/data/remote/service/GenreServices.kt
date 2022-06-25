package com.tmdb.app.data.remote.service

import com.tmdb.app.data.remote.model.response.GenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreServices {

    @GET(value = "genre/movie/list")
    suspend fun getGenreList(
        @Query(value = "api_key") apiKey: String
    ): GenreResponse
}