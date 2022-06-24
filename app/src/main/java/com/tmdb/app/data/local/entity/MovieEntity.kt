package com.tmdb.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.Movie

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    var title: String,
    var genres: List<Genre>,
    var overview: String,
    var popularity: Double,
    var releaseDate: Long,
    var voteAverage: Double,
    var voteCount: Int
) {
    companion object {
        fun fromDomain(model: Movie) : MovieEntity {
            return MovieEntity(
                id = model.id,
                title = model.title,
                genres = model.genres,
                overview = model.overview,
                popularity = model.popularity,
                releaseDate = model.releaseDate,
                voteAverage = model.voteAverage,
                voteCount = model.voteCount
            )
        }
    }

    fun toDomain() : Movie {
        return Movie(
            id = id,
            title = title,
            genres = genres,
            overview = overview,
            popularity = popularity,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }
}