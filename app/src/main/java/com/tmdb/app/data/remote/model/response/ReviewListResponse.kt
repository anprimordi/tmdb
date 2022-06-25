package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.BuildConfig
import com.tmdb.app.data.remote.util.RemoteDateTimeUtils
import com.tmdb.app.domain.model.Author
import com.tmdb.app.domain.model.Review

data class ReviewListResponse(
    @SerializedName(value = "results") val results : List<ReviewResponse>? = null,
) {

    fun toDomain(): List<Review> {
        val list = arrayListOf<Review>()

        results?.forEach { list.add(it.toDomain()) }

        return list
    }
}
