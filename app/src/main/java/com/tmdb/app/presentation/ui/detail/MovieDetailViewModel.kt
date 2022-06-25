package com.tmdb.app.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tmdb.app.di.datasource.Repository
import com.tmdb.app.domain.datasource.MovieDataSource
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    @Repository private val movieDataSource: MovieDataSource
) : BaseViewModel(), MovieDetailContract.Presenter {

    private val _movieObservable = MutableLiveData<Result<Movie>>()
    override val movieObservable: LiveData<Result<Movie>>
        get() = _movieObservable

    private val _reviewListObservable = MutableLiveData<Result<List<Review>>>()
    override val reviewListObservable: LiveData<Result<List<Review>>>
        get() = _reviewListObservable

    override fun loadData(movieId: Int) {
        viewModelScope.launch {
            _movieObservable.postValue(Loading())
            val result = movieDataSource.getMovieDetail(movieId)
            _movieObservable.postValue(result)
        }
    }

    override fun loadReview(movieId: Int) {
        viewModelScope.launch {
            _reviewListObservable.postValue(Loading())
            val result = movieDataSource.getReviewList(movieId)
            _reviewListObservable.postValue(result)
        }
    }
}