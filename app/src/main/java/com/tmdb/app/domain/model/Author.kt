package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Author(
    val name: String,
    val username: String,
    val avatarPath: String?,
    val rating: Int?
) : Model {
    companion object {
        val DEFAULT = Author(
            name = "",
            username = "",
            avatarPath = null,
            rating = null
        )
    }
}
