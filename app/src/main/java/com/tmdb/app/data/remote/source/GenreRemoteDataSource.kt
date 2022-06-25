package com.tmdb.app.data.remote.source

import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.service.GenreServices
import com.tmdb.app.data.remote.util.execute
import com.tmdb.app.domain.datasource.GenreDataSource
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GenreRemoteDataSource @Inject constructor(
    private val genreServices: GenreServices
) : GenreDataSource {

    override suspend fun getGenreList(): Result<List<Genre>?> {
        return withContext(Dispatchers.IO) {
            execute {
                val apiKey = BuildConfig.API_KEY
                genreServices.getGenreList(apiKey)
            } map {
                it.toDomain()
            }
        }
    }
}