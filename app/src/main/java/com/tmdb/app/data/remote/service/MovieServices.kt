package com.tmdb.app.data.remote.service

import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.model.response.MovieByGenreResponse
import com.tmdb.app.data.remote.model.response.MovieResponse
import com.tmdb.app.data.remote.model.response.ReviewListResponse
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.common.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieServices {

    @GET(value = "discover/movie")
    suspend fun getMovieListByGenre(
        @Query(value = "api_key") apiKey : String,
        @Query(value = "with_genres") genreId : String,
        @Query(value = "sort_by") sortBy: String = "popularity.desc",
        @Query(value = "include_adult") includeAdult : Boolean = false
    ) : MovieByGenreResponse

    @GET(value = "movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "api_key") apiKey : String
    ) : MovieResponse

    @GET(value = "movie/{movie_id}/reviews")
    suspend fun getReviewList(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "api_key") apiKey : String
    ) : ReviewListResponse


}