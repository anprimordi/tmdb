package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.BuildConfig
import com.tmdb.app.domain.model.Author

data class AuthorResponse(
    @SerializedName(value = "username") val username : String? = null,
    @SerializedName(value = "avatar_path") val imageUrl: String? = null
) {

    private val baseUrl = BuildConfig.IMAGE_URL

    fun toDomain(): Author {
        return Author(
            username = username ?: "",
            avatarPath = "${baseUrl}${imageUrl}"
        )
    }
}