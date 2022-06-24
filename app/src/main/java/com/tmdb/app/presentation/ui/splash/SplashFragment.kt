package com.tmdb.app.presentation.ui.splash

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tmdb.app.R
import com.tmdb.app.databinding.FragmentSplashBinding
import com.tmdb.app.domain.model.User
import com.tmdb.app.domain.model.common.Error
import com.tmdb.app.domain.model.common.Loading
import com.tmdb.app.domain.model.common.Result
import com.tmdb.app.domain.model.common.Success
import com.tmdb.app.presentation.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashContract.Presenter>(), SplashContract.View {

    override val layoutResourceId: Int = R.layout.fragment_splash
    override val presenter: SplashContract.Presenter by viewModels<SplashViewModel>()

    override fun onInitialize() {
        super.onInitialize()
        presenter.loadUser()
        presenter.userStateObservable.observe(viewLifecycleOwner) { event ->
            event.getAvailableEvent()?.let {
                fetchUserState(it)
            }
        }
    }

    override fun fetchUserState(result: Result<User?>) {
        when(result) {
            is Loading -> {}
            is Error -> {
                showErrorMessage(result, binding.root)
            }
            is Success -> {
                openGenrePage()
            }
        }
    }

    override fun openGenrePage() {
        val direction = SplashFragmentDirections.actionSplashFragmentToGenreFragment()
        findNavController().navigate(direction)
    }

}