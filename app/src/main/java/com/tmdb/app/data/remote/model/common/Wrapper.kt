package com.tmdb.app.data.remote.model.common

import com.google.gson.annotations.SerializedName

data class Wrapper<T>(
    @SerializedName(value = "status") val isSuccess: Boolean,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data", alternate = ["result"]) val data: T? = null,
)