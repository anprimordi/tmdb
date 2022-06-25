package com.tmdb.app.presentation.ui.detail

import androidx.lifecycle.LiveData
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BasePresenter
import com.tmdb.app.presentation.util.base.BaseView

interface MovieDetailContract {

    interface View : BaseView {
        fun fetchMovie(result: Result<Movie>)
        fun openReviewPage(movieId: Int)
        fun openTrailerPage()
    }

    interface Presenter : BasePresenter {
        val movieObservable: LiveData<Result<Movie>>
        val reviewListObservable: LiveData<Result<List<Review>>>
        fun loadData(movieId: Int)
        fun loadReview(movieId: Int)
    }
}