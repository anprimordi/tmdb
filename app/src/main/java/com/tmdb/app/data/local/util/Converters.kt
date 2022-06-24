package com.tmdb.app.data.local.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tmdb.app.domain.model.Genre

class Converters {
    @TypeConverter
    fun listToJsonString(value: List<Genre>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<Genre>::class.java).toList()
}