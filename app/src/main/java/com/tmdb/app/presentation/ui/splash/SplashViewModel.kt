package com.tmdb.app.presentation.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tmdb.app.di.datasource.Repository
import com.tmdb.app.domain.datasource.UserDataSource
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.Event
import com.tmdb.app.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @Repository private val userDataSource: UserDataSource
) : BaseViewModel(), SplashContract.Presenter {

    private val _userStateObservable = MutableLiveData<Event<Result<User?>>>()
    override val userStateObservable: LiveData<Event<Result<User?>>>
        get() = _userStateObservable


    override fun loadUser() {
        viewModelScope.launch {
            val result = userDataSource.getRequestToken()
            if (result != null) {
                _userStateObservable.postValue(Event(result))
            }
        }
    }
}