package com.tmdb.app.presentation.ui.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tmdb.app.databinding.ItemListGenreBinding
import com.tmdb.app.domain.model.Genre
import com.tmdb.app.presentation.util.comparator.ModelComparator
import javax.inject.Inject

class GenreListAdapter @Inject constructor(
    private val onItemClick: (genre: Genre) -> Unit
) : ListAdapter<Genre, GenreListAdapter.ViewHolder>(ModelComparator<Genre>()) {

    inner class ViewHolder(val binding: ItemListGenreBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListGenreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.genre = item
        holder.binding.root.setOnClickListener { onItemClick(item) }
    }
}