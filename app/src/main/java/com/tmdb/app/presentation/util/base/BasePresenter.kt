package com.tmdb.app.presentation.util.base

import androidx.lifecycle.LiveData
import com.tmdb.app.presentation.util.Event

interface BasePresenter {

    val stateLoading: LiveData<Boolean>
    val eventMessage: LiveData<Event<String>>
    val eventImportantMessage: LiveData<Event<String>>
    fun isLoading(): Boolean
    fun setLoading(isLoading: Boolean = true)
    fun postMessageEvent(message: String)
    fun postImportantMessageEvent(message: String)
//    suspend fun getCurrentUser(): Guest?

}