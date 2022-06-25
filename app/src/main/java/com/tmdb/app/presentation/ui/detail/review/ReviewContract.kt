package com.tmdb.app.presentation.ui.detail.review

import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.presentation.util.base.BaseView

interface ReviewContract {

    interface View : BaseView {
        fun fetchReviewList(result: Result<List<Review>>)
    }

}