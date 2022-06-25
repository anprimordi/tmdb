package com.tmdb.app.presentation.ui.list

import androidx.lifecycle.LiveData
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BasePresenter
import com.tmdb.app.presentation.util.base.BaseView

interface MovieListContract {
    interface View : BaseView {
        fun fetchMovieList(result: Result<List<Movie>>)
        fun openMovieDetailPage(movieId: Int)
    }
    interface Presenter : BasePresenter {
        val movieListObservable: LiveData<Result<List<Movie>>>
        fun loadData(genreId: Int)
    }
}