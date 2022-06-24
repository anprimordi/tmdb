package com.tmdb.app.domain.model

import com.tmdb.app.domain.model.common.Model

data class Trailer(
    val id: String,
    val name: String,
    val key: String,
    val site: String,
    val size: Int,
    val type: String
) : Model {
    companion object {
        val DEFAULT = Trailer(
            id = "",
            name = "",
            key = "",
            site = "",
            size = 0,
            type = ""
        )
    }
}