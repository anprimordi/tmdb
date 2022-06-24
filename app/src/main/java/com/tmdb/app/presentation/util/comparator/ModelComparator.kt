package com.tmdb.app.presentation.util.comparator

import androidx.recyclerview.widget.DiffUtil
import com.tmdb.app.domain.model.common.Model

class ModelComparator<T : Model> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isItemSameWith(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isContentSameWith(newItem)
    }
}