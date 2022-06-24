package com.tmdb.app.di.datasource

import com.tmdb.app.data.local.source.MovieLocalDataSource
import com.tmdb.app.data.local.source.UserLocalDataSource
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.datasource.UserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    @LocalDataSource
    abstract fun bindUserDataSource(userLocalDataSource: UserLocalDataSource): UserDataSource

    @Binds
    @LocalDataSource
    abstract fun bindMovieDataSource(movieLocalDataSource: MovieLocalDataSource): MovieDataSource

}