package com.lkw1120.news.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffCallback<T>: DiffUtil.ItemCallback<T>() {
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem
}