package com.tmdb.app.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.tmdb.app.data.local.entity.MovieEntity

@Dao
interface MovieDao : BaseDao<MovieEntity> {

    @Query(value = "SELECT * FROM movies WHERE id = :movieId")
    suspend fun getMovieDetail(movieId: Int): MovieEntity
}