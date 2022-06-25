package com.tmdb.app.presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tmdb.app.BuildConfig
import com.tmdb.app.databinding.ItemListMovieBinding
import com.tmdb.app.domain.model.Movie
import com.tmdb.app.presentation.util.DateTimeFormatter
import com.tmdb.app.presentation.util.comparator.ModelComparator
import javax.inject.Inject

class MovieListAdapter @Inject constructor(
    private val onItemClick: (movie: Movie) -> Unit
) : ListAdapter<Movie, MovieListAdapter.ViewHolder>(ModelComparator<Movie>()) {
    class ViewHolder(val binding: ItemListMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        Glide.with(holder.binding.root.context).load(item.posterUrl).into(holder.binding.imagePoster)
        holder.binding.movie = item
        holder.binding.textReleaseDate.text = DateTimeFormatter.formatDate(item.releaseDate)
        holder.binding.root.setOnClickListener { onItemClick(item) }
    }
}