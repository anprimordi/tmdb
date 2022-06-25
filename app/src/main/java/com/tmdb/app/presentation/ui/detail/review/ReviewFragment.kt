package com.tmdb.app.presentation.ui.detail.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tmdb.app.R
import com.tmdb.app.databinding.FragmentReviewBinding
import com.tmdb.app.domain.model.Review
import com.tmdb.app.domain.model.common.Error
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import com.tmdb.app.presentation.ui.detail.MovieDetailContract
import com.tmdb.app.presentation.ui.detail.MovieDetailViewModel
import timber.log.Timber

class ReviewFragment : BottomSheetDialogFragment(), ReviewContract.View {

    private lateinit var binding : FragmentReviewBinding
    private val presenter : MovieDetailContract.Presenter by activityViewModels<MovieDetailViewModel>()
    private val args: ReviewFragmentArgs by navArgs()

    private val adapter = ReviewListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_TheMovieDB_BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_review, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.view = this
        binding.presenter = presenter

        binding.rvMovieList.adapter = adapter

        presenter.loadReview(args.movieId)
        presenter.reviewListObservable.observe(viewLifecycleOwner) {
            fetchReviewList(it)
        }

        return binding.root
    }

    override fun fetchReviewList(result: Result<List<Review>>) {
        when (result) {
            is Loading -> {}
            is Error -> showErrorMessage(result, binding.root)
            is Success -> {
                adapter.submitList(result.data)
            }
        }
    }

    override fun <T> getErrorMessage(result: Error<T>): String = ""

    override fun <T> showErrorMessage(result: Error<T>, view: View) {}

    override fun showUnderDevelopmentMessage() {}

    override fun closePage() {
        findNavController().navigateUp()
    }

}