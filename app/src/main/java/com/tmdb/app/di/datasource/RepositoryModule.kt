package com.tmdb.app.di.datasource

import com.tmdb.app.data.repository.GenreRepository
import com.tmdb.app.data.repository.MovieRepository
import com.tmdb.app.data.repository.UserRepository
import com.tmdb.app.domain.datasource.GenreDataSource
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.datasource.UserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Qualifier
annotation class Repository

@Qualifier
annotation class LocalDataSource

@Qualifier
annotation class RemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Repository
    abstract fun bindGenreDataSource(genreRepository: GenreRepository): GenreDataSource

    @Binds
    @Repository
    abstract fun bindMovieDataSource(movieRepository: MovieRepository): MovieDataSource

    @Binds
    @Repository
    abstract fun bindUserDataSource(userRepository: UserRepository): UserDataSource

}