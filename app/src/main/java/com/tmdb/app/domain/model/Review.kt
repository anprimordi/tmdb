package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Review(
    val author: Author,
    val content: String
) : Model {
    companion object {
        val DEFAULT = Review(
            author = Author(
                name = "",
                username = "",
                avatarPath = null,
                rating = null
            ), content = ""
        )
    }
}