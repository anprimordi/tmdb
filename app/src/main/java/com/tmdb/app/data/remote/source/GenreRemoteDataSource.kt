package com.tmdb.app.data.remote.source

import com.tmdb.app.domain.datasource.GenreDataSource
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Result
import javax.inject.Inject

class GenreRemoteDataSource @Inject constructor() : GenreDataSource {
    override suspend fun getGenreList(): Result<List<Genre>> {
        TODO("Not yet implemented")
    }
}