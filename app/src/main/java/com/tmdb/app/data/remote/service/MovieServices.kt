package com.tmdb.app.data.remote.service

import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {

    @GET(value = "discover/movie")
    suspend fun getMovieListByGenre(
        @Query(value = "api_key") apiKey : String,
        @Query(value = "with_genre") genreId : Int,
        @Query(value = "sort_by") sortBy: String = "popularity.desc",
        @Query(value = "include_adult") inclueAdult : Boolean = false
    ) : MovieResponse
}