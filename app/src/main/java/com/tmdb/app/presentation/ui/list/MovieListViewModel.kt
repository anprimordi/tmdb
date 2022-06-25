package com.tmdb.app.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tmdb.app.di.datasource.Repository
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    @Repository private val movieDataSource: MovieDataSource
) : BaseViewModel(), MovieListContract.Presenter {

    private val _movieListObservable = MutableLiveData<Result<List<Movie>>>()
    override val movieListObservable: LiveData<Result<List<Movie>>>
        get() = _movieListObservable

    override fun loadData(genreId: Int) {
        viewModelScope.launch {
            val result = movieDataSource.getMovieListByGenre(genreId)
            _movieListObservable.postValue(result)
        }
    }
}