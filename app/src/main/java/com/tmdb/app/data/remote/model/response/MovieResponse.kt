package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.util.RemoteDateTimeUtils
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.Movie
import java.util.*

data class MovieResponse(
    @SerializedName(value = "page") val id: Int? = null,
    @SerializedName(value = "results") val results: List<Result>? = emptyList(),
    @SerializedName(value = "total_pages") val totalPages: Int? = null,
    @SerializedName(value = "total_result") val totalResult: Int? = null
) {

    data class Result(
        @SerializedName(value = "id") val id: Int? = null,
        @SerializedName(value = "original_title") val title: String? = null,
        @SerializedName(value = "poster_path") val posterUrl: String? = null,
        @SerializedName(value = "release_date") val releaseDate: String? = null
    ) {
        fun toDomain() : Movie {
            return Movie(
                id = id ?: 0,
                title = title ?: "",
                posterUrl = posterUrl ?: "",
                genres = listOf(),
                overview = "",
                popularity = 0.0,
                releaseDate = RemoteDateTimeUtils.parseServerDate(releaseDate) ?: 0,
                voteAverage = 0.0,
                voteCount = 0
            )
        }
    }

    fun toDomain() : List<Movie> {
        val list = arrayListOf<Movie>()

        val baseImgUrl = BuildConfig.IMAGE_URL

        results?.forEach {
            list.add(Movie(
                id = it.id ?: 0,
                title = it.title ?: "",
                posterUrl = "${baseImgUrl}${it.posterUrl}" ?: "",
                genres = listOf(),
                overview = "",
                popularity = 0.0,
                releaseDate = RemoteDateTimeUtils.parseServerDate(it.releaseDate) ?: Date().time,
                voteAverage = 0.0,
                voteCount = 0
            ))
        }

        return list
    }
}