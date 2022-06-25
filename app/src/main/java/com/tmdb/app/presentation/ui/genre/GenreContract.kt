package com.tmdb.app.presentation.ui.genre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BasePresenter
import com.tmdb.app.presentation.util.base.BaseView

interface GenreContract {
    interface View : BaseView {
        fun fetchGenreList(result: Result<List<Genre>?>)
        fun openMovieListPage(genreId: Int, genreName: String)
    }

    interface Presenter : BasePresenter {
        val genreListObservable: LiveData<Result<List<Genre>?>>
        fun loadData()
    }
}