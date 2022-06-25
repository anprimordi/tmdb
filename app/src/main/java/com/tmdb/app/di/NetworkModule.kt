package com.tmdb.app.di

import com.tmdb.app.data.remote.AppRemoteClient
import com.tmdb.app.data.remote.service.GenreServices
import com.tmdb.app.data.remote.service.MovieServices
import com.tmdb.app.data.remote.service.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideGenreService(appRemoteClient: AppRemoteClient): GenreServices {
        return appRemoteClient.create(GenreServices::class.java)
    }

    @Provides
    fun provideMovieService(appRemoteClient: AppRemoteClient): MovieServices {
        return appRemoteClient.create(MovieServices::class.java)
    }

    @Provides
    fun provideUserService(appRemoteClient: AppRemoteClient): UserServices {
        return appRemoteClient.create(UserServices::class.java)
    }

}