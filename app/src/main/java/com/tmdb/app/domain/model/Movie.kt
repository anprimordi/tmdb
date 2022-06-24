package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Movie(
    val id: Int,
    val title: String,
    val genres: List<Genre>,
    val overview: String,
    val popularity: Double,
    val releaseDate: Long,
    val voteAverage: Double,
    val voteCount: Int
) : Model {
    companion object {
        val DEFAULT = Movie(
            id = 0,
            title = "",
            genres = listOf(),
            overview = "",
            popularity = 0.0,
            releaseDate = 0,
            voteAverage = 0.0,
            voteCount = 0
        )
    }
}