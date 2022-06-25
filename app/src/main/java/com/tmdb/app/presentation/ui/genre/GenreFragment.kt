package com.tmdb.app.presentation.ui.genre

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tmdb.app.R
import com.tmdb.app.databinding.FragmentGenreBinding
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.domain.model.common.Error
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import com.tmdb.app.presentation.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreFragment : BaseFragment<FragmentGenreBinding, GenreContract.Presenter>(),
    GenreContract.View {

    override val layoutResourceId: Int = R.layout.fragment_genre
    override val presenter: GenreContract.Presenter by viewModels<GenreViewModel>()

    private var adapter = GenreListAdapter { openMovieListPage(genreId = it.id, it.name) }

    override fun onInitialize() {
        binding.view = this
        binding.presenter = presenter
        binding.rvGenre.adapter = adapter

        presenter.loadData()
        presenter.genreListObservable.observe(viewLifecycleOwner) {
            fetchGenreList(it)
        }
    }

    override fun fetchGenreList(result: Result<List<Genre>?>) {
        when (result) {
            is Loading -> binding.swipeRefresh.isRefreshing = true
            is Error -> binding.swipeRefresh.isRefreshing = false
            is Success -> {
                binding.swipeRefresh.isRefreshing = false
                adapter.submitList(result.data)
            }
        }
    }

    override fun openMovieListPage(genreId: Int, genreName: String) {
        val direction = GenreFragmentDirections.actionGenreFragmentToMovieListFragment(genreId, genreName)
        findNavController().navigate(direction)
    }


}