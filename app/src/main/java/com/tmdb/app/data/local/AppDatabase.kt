package com.tmdb.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tmdb.app.BuildConfig
import com.tmdb.app.data.local.dao.MovieDao
import com.tmdb.app.data.local.entity.MovieEntity
import com.tmdb.app.data.local.util.Converters

@Database(
    version = BuildConfig.DB_VERSION,
    exportSchema = false,
    entities = [
        MovieEntity::class,
    ]
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var sInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return sInstance ?: synchronized(this) {
                sInstance ?: buildDatabase(context).also { sInstance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                BuildConfig.DB_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }

    abstract fun movieDao(): MovieDao

}