package com.tmdb.app.di

import com.tmdb.app.data.remote.AppRemoteClient
import com.tmdb.app.data.remote.service.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideUserService(appRemoteClient: AppRemoteClient): UserServices {
        return appRemoteClient.create(UserServices::class.java)
    }
}