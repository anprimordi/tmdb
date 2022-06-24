package com.tmdb.app.domain.datasource

import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.Trailer
import com.tmdb.app.domain.model.common.Result

interface MovieDataSource {
    suspend fun getMovieListByGenre(genreName: String) : Result<List<Movie>>
    suspend fun getMovieDetail(movieId: Int) : Result<Movie>
    suspend fun getMovieTrailer(movieId: Int) : Result<Trailer>
    suspend fun getReviewList(movieId: Int) : Result<List<Review>>
}