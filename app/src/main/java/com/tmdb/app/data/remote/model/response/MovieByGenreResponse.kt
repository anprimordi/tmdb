package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.BuildConfig
import com.tmdb.app.domain.model.Movie

data class MovieByGenreResponse(
    @SerializedName(value = "page") val id: Int? = null,
    @SerializedName(value = "results") val results: List<MovieResponse>? = emptyList(),
    @SerializedName(value = "total_pages") val totalPages: Int? = null,
    @SerializedName(value = "total_result") val totalResult: Int? = null
) {
    fun toDomain(): List<Movie> {
        val list = arrayListOf<Movie>()

        results?.forEach { list.add(it.toDomain()) }

        return list
    }
}