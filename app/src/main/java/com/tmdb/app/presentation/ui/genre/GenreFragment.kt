package com.tmdb.app.presentation.ui.genre

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tmdb.app.R

class GenreFragment : Fragment() {

    companion object {
        fun newInstance() = GenreFragment()
    }

    private lateinit var viewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GenreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}