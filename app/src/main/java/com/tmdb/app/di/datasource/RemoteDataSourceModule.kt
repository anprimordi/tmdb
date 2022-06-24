package com.tmdb.app.di.datasource

import com.tmdb.app.data.remote.source.GenreRemoteDataSource
import com.tmdb.app.data.remote.source.MovieRemoteDataSource
import com.tmdb.app.data.remote.source.UserRemoteDataSource
import com.tmdb.app.domain.datasource.GenreDataSource
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.datasource.UserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @RemoteDataSource
    abstract fun bindGenreDataSource(genreRemoteDataSource: GenreRemoteDataSource): GenreDataSource

    @Binds
    @RemoteDataSource
    abstract fun bindMovieDataSource(movieRemoteDataSource: MovieRemoteDataSource): MovieDataSource

    @Binds
    @RemoteDataSource
    abstract fun bindUserDataSource(userRemoteDataSource: UserRemoteDataSource): UserDataSource
}