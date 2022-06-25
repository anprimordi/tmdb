package com.tmdb.app.domain.datasource

import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Result

interface GenreDataSource {
    suspend fun getGenreList() : Result<List<Genre>?>
}