package com.tmdb.app.presentation.ui.detail

import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tmdb.app.R
import com.tmdb.app.databinding.FragmentMovieDetailBinding
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.common.Error
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import com.tmdb.app.presentation.util.DateTimeFormatter
import com.tmdb.app.presentation.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding, MovieDetailContract.Presenter>(),
    MovieDetailContract.View {

    override val layoutResourceId: Int = R.layout.fragment_movie_detail
    override val presenter: MovieDetailContract.Presenter by activityViewModels<MovieDetailViewModel>()

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onInitialize() {
        binding.view = this
        binding.presenter = presenter

        binding.movieId = args.movieId

        presenter.loadData(args.movieId)
        presenter.movieObservable.observe(viewLifecycleOwner) {
            fetchMovie(it)
        }
    }

    override fun fetchMovie(result: Result<Movie>) {
        when (result) {
            is Loading -> {
                binding.swipeRefresh.isRefreshing = true
                binding.swipeRefresh.isVisible = false
            }
            is Error -> {
                binding.swipeRefresh.isRefreshing = false
                binding.swipeRefresh.isVisible = false
            }
            is Success -> {
                binding.swipeRefresh.isRefreshing = false
                binding.swipeRefresh.isVisible = true
                val movie = result.data
                binding.movie = movie
                Glide.with(requireContext()).load(movie.posterUrl).into(binding.imagePoster)
                binding.textGenres.text = movie.genres.joinToString(separator = ", ") { it.name }
                binding.textVoteAverage.text = movie.voteAverage.toString()
                binding.textReleaseDate.text = DateTimeFormatter.formatDate(movie.releaseDate)
            }
        }
    }

    override fun openReviewPage(movieId: Int) {
        val directions = MovieDetailFragmentDirections.actionMovieDetailFragmentToReviewFragment(movieId)
        findNavController().navigate(directions)
    }

    override fun openTrailerPage() {
        showUnderDevelopmentMessage()
    }


}