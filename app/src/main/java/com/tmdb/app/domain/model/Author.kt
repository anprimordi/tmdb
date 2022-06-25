package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Author(
    val username: String,
    val avatarPath: String?
) : Model {
    companion object {
        val DEFAULT = Author(
            username = "",
            avatarPath = ""
        )
    }
}
