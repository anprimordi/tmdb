package com.tmdb.app.presentation.ui.genre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tmdb.app.di.datasource.Repository
import com.tmdb.app.domain.datasource.GenreDataSource
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(
    @Repository private val genreDataSource: GenreDataSource
) : BaseViewModel(), GenreContract.Presenter {

    private val _genreListObservable = MutableLiveData<Result<List<Genre>?>>()
    override val genreListObservable: LiveData<Result<List<Genre>?>>
        get() = _genreListObservable

    override fun loadData() {
        viewModelScope.launch {
            _genreListObservable.postValue(Loading())
            val result = genreDataSource.getGenreList()
            if (result != null) {
                _genreListObservable.postValue(result)
            }
        }
    }

}