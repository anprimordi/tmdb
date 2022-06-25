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
    @LocalDataSource private val localDataSource: MovieDataSource,
    @RemoteDataSource private val remoteMovieDataSource: MovieDataSource
) : MovieDataSource {
    override suspend fun getMovieListByGenre(genreId: Int): Result<List<Movie>> {
        return remoteMovieDataSource.getMovieListByGenre(genreId)
    }

    override suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return remoteMovieDataSource.getMovieDetail(movieId)
    }

    override suspend fun getMovieTrailer(movieId: Int): Result<Trailer> {
        return remoteMovieDataSource.getMovieTrailer(movieId)
    }

    override suspend fun getReviewList(movieId: Int): Result<List<Review>> {
        return remoteMovieDataSource.getReviewList(movieId)
    }
}