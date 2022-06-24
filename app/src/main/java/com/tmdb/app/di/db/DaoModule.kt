package com.krakatio.aplikasiconvertpulsa.di.db

import com.tmdb.app.data.local.AppDatabase
import com.tmdb.app.data.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideProviderDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

}