package com.tmdb.app.data.local.source

import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.Trailer
import com.tmdb.app.domain.model.common.Result
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor() : MovieDataSource {
    override suspend fun getMovieListByGenre(genreId: Int): Result<List<Movie>> {
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