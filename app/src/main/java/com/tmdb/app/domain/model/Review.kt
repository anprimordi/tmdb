package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Review(
    val author: Author,
    val content: String,
    val timestamp: Long
) : Model {
    companion object {
        val DEFAULT = Review(
            author = Author.DEFAULT,
            content = "",
            timestamp = 0
        )
    }
}