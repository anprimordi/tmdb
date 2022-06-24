package com.tmdb.app.presentation.ui.splash

import androidx.lifecycle.LiveData
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.Event
import com.tmdb.app.presentation.util.base.BasePresenter
import com.tmdb.app.presentation.util.base.BaseView

interface SplashContract {
    interface View : BaseView {
        fun fetchUserState(result: Result<User?>)
        fun openGenrePage()
    }
    interface Presenter : BasePresenter {
        val userStateObservable: LiveData<Event<Result<User?>>>
        fun loadUser()
    }
}