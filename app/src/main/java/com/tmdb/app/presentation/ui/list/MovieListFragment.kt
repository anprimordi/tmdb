package com.tmdb.app.presentation.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tmdb.app.R
import com.tmdb.app.databinding.FragmentMovieListBinding
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.domain.model.common.Error
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import com.tmdb.app.presentation.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding, MovieListContract.Presenter>(), MovieListContract.View {

    override val layoutResourceId: Int = R.layout.fragment_movie_list
    override val presenter: MovieListContract.Presenter by viewModels<MovieListViewModel>()

    private val args : MovieListFragmentArgs by navArgs()

    private val adapter = MovieListAdapter {
        openMovieDetailPage(it.id)
    }

    override fun onInitialize() {
        binding.view = this
        binding.presenter = presenter
        binding.rvMovieList.adapter = adapter
        binding.genreId = args.genreId

        binding.title = args.genreName

        presenter.loadData(args.genreId)
        presenter.movieListObservable.observe(viewLifecycleOwner) {
            fetchMovieList(it)
        }
    }

    override fun fetchMovieList(result: Result<List<Movie>>) {
        when(result) {
            is Loading -> binding.swipeRefresh.isRefreshing = true
            is Error -> binding.swipeRefresh.isRefreshing = false
            is Success -> {
                binding.swipeRefresh.isRefreshing = false
                adapter.submitList(result.data)
            }
        }
    }

    override fun openMovieDetailPage(movieId: Int) {
        val direction = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movieId)
        findNavController().navigate(direction)
    }

}