package com.tmdb.app.presentation.ui.detail.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tmdb.app.databinding.ItemListReviewBinding
import com.tmdb.app.domain.model.Review
import com.tmdb.app.presentation.util.DateTimeFormatter
import com.tmdb.app.presentation.util.comparator.ModelComparator
import javax.inject.Inject

class ReviewListAdapter @Inject constructor() :
    ListAdapter<Review, ReviewListAdapter.ViewHolder>(ModelComparator<Review>()) {

    class ViewHolder(val binding: ItemListReviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.textName.text = item.author.username
        holder.binding.textDate.text = DateTimeFormatter.formatDate(item.timestamp)
        holder.binding.textContent.text = item.content
        Glide.with(holder.binding.root.context).load(item.author.avatarPath).into(holder.binding.imageLogoProvider)
    }
}