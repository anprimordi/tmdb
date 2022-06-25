package com.tmdb.app.data.repository

import com.tmdb.app.di.datasource.RemoteDataSource
import com.tmdb.app.domain.datasource.GenreDataSource
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Result
import javax.inject.Inject

class GenreRepository @Inject constructor(
    @RemoteDataSource private val remoteDataSource: GenreDataSource
) : GenreDataSource{
    override suspend fun getGenreList(): Result<List<Genre>?> {
        return remoteDataSource.getGenreList()
    }
}