package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Genre(
    val id: Int,
    val name: String
) : Model {
    companion object {
        val DEFAULT = Genre(
            id = 0,
            name = ""
        )
    }
}