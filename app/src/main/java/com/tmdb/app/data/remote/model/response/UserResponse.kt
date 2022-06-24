package com.tmdb.app.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.tmdb.app.domain.model.User

data class UserResponse(
    @SerializedName(value = "success") val success: Boolean? = null,
    @SerializedName(value = "expired_at") val expiredAt: String? = null,
    @SerializedName(value = "request_token") val requestToken: String? = null
) {
    fun toDomain() : User {
        return User(token = requestToken ?: "")
    }
}
