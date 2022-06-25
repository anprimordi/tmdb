package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.domain.model.Genre

data class GenreResponse(
    @SerializedName(value = "genres") val genres: List<Genres>? = emptyList(),
) {
    data class Genres(
        @SerializedName(value = "id") val id: Int? = null,
        @SerializedName(value = "name") val name: String? = null
    ) {
        fun toDomain() : Genre {
            return Genre(
                id = id ?: 0,
                name = name ?: ""
            )
        }
    }

    fun toDomain() : List<Genre> {
        val list = arrayListOf<Genre>()

        genres?.forEach { list.add(it.toDomain()) }

        return list
    }
}
