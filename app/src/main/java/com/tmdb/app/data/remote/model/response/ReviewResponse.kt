package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.data.remote.util.RemoteDateTimeUtils
import com.tmdb.app.domain.model.Author
import com.tmdb.app.domain.model.Review

data class ReviewResponse(
    @SerializedName(value = "author_details") val author : AuthorResponse? = null,
    @SerializedName(value = "content") val content: String? = null,
    @SerializedName(value = "created_at") val createdAt : String? = null,
) {

    fun toDomain(): Review {
        return Review(
            author = author?.toDomain() ?: Author.DEFAULT,
            content = content ?: "",
            timestamp = RemoteDateTimeUtils.parseServerDateTimeReview(createdAt)?: 0
        )
    }
}
