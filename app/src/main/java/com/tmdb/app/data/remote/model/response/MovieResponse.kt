package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.util.RemoteDateTimeUtils
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.Movie

data class MovieResponse(
    @SerializedName(value = "id") val id: Int? = null,
    @SerializedName(value = "original_title") val title: String? = null,
    @SerializedName(value = "poster_path") val posterUrl: String? = null,
    @SerializedName(value = "genres") val genre: List<Genres>? = null,
    @SerializedName(value = "overview") val overview: String? = null,
    @SerializedName(value = "popularity") val popularity: Double? = null,
    @SerializedName(value = "vote_average") val voteAverage: Double? = null,
    @SerializedName(value = "vote_count") val voteCount: Int? = null,
    @SerializedName(value = "release_date") val releaseDate: String? = null
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

    fun toDomain(): Movie {

        val baseImgUrl = BuildConfig.IMAGE_URL

        val list = arrayListOf<Genre>()

        genre?.forEach { list.add(it.toDomain()) }

        return Movie(
            id = id ?: 0,
            title = title ?: "",
            posterUrl = "${baseImgUrl}${posterUrl}",
            genres = list,
            overview = overview ?: "",
            popularity = popularity ?: 0.0,
            releaseDate = RemoteDateTimeUtils.parseServerDate(releaseDate) ?: 0,
            voteAverage = voteAverage ?: 0.0,
            voteCount = voteCount ?: 0
        )
    }
}