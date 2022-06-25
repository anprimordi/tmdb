package com.tmdb.app.data.remote.source

import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.service.MovieServices
import com.tmdb.app.data.remote.util.RemoteDateTimeUtils
import com.tmdb.app.data.remote.util.execute
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.Trailer
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieServices: MovieServices
) : MovieDataSource {
    override suspend fun getMovieListByGenre(genreId: Int): Result<List<Movie>> {

        /*val baseUrl = BuildConfig.IMAGE_URL

        val list = listOf(
            Movie(
                id = 0,
                title = "abc",
                posterUrl = "${baseUrl}/t0mwKhUDa62hdhdKSsN4xMfhY5Z.jpg",
                genres = listOf(
                    Genre(
                        id = 0,
                        name = "action"
                    )
                ),
                overview = "this is nice",
                popularity = 1.0,
                releaseDate = RemoteDateTimeUtils.parseServerDate("1990-02-01") ?: Date().time,
                voteAverage = 1.0,
                voteCount = 12
            ),
            Movie(
                id = 1,
                title = "abc",
                posterUrl = "${baseUrl}/t0mwKhUDa62hdhdKSsN4xMfhY5Z.jpg",
                genres = listOf(
                    Genre(
                        id = 0,
                        name = "action"
                    )
                ),
                overview = "this is nice",
                popularity = 1.0,
                releaseDate = RemoteDateTimeUtils.parseServerDate("1990-02-01") ?: Date().time,
                voteAverage = 1.0,
                voteCount = 12
            ),
            Movie(
                id = 2,
                title = "abc",
                posterUrl = "${baseUrl}/t0mwKhUDa62hdhdKSsN4xMfhY5Z.jpg",
                genres = listOf(
                    Genre(
                        id = 0,
                        name = "action"
                    )
                ),
                overview = "this is nice",
                popularity = 1.0,
                releaseDate = RemoteDateTimeUtils.parseServerDate("1990-02-01") ?: Date().time,
                voteAverage = 1.0,
                voteCount = 12
            )
        )
        return Success(list)*/

        return withContext(Dispatchers.IO) {
            execute {
                val apiKey = BuildConfig.API_KEY
                movieServices.getMovieListByGenre(apiKey, genreId)
            } map {
                it.toDomain()
            }
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieTrailer(movieId: Int): Result<Trailer> {
        TODO("Not yet implemented")
    }

    override suspend fun getReviewList(movieId: Int): Result<List<Review>> {
        TODO("Not yet implemented")
    }
}