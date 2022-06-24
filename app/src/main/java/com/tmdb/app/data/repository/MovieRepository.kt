package com.tmdb.app.data.repository

import com.tmdb.app.di.datasource.LocalDataSource
import com.tmdb.app.di.datasource.RemoteDataSource
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.Trailer
import com.tmdb.app.domain.model.common.Result
import javax.inject.Inject

class MovieRepository @Inject constructor(
    @LocalDataSource localDataSource: MovieDataSource,
    @RemoteDataSource remoteMovieDataSource: MovieDataSource
) : MovieDataSource {
    override suspend fun getMovieListByGenre(genreName: String): Result<List<Movie>> {
        TODO("Not yet implemented")
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