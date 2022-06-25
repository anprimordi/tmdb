package com.tmdb.app.data.remote.source

import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.service.MovieServices
import com.tmdb.app.data.remote.util.execute
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.Trailer
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.UnsupportedError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieServices: MovieServices
) : MovieDataSource {
    override suspend fun getMovieListByGenre(genreId: Int): Result<List<Movie>> {

        return withContext(Dispatchers.IO) {
            execute {
                val apiKey = BuildConfig.API_KEY
                movieServices.getMovieListByGenre(apiKey, genreId.toString())
            } map {
                it.toDomain()
            }
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return withContext(Dispatchers.IO) {
            execute {
                val apiKey = BuildConfig.API_KEY
                movieServices.getMovieDetail(movieId, apiKey)
            } map {
                it.toDomain()
            }
        }
    }

    override suspend fun getMovieTrailer(movieId: Int): Result<Trailer> {
        return UnsupportedError(this)
    }

    override suspend fun getReviewList(movieId: Int): Result<List<Review>> {
        return withContext(Dispatchers.IO) {
            execute {
                val apiKey = BuildConfig.API_KEY
                movieServices.getReviewList(movieId, apiKey)
            } map {
                it.toDomain()
            }
        }
    }
}