package com.lkw1120.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lkw1120.news.databinding.ItemWordBinding

class WordListAdapter: ListAdapter<String, RecyclerView.ViewHolder>(DiffCallback<String>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ItemViewHolder(ItemWordBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ItemViewHolder).bind(item)
    }

    inner class ItemViewHolder(private val binding: ItemWordBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.apply {
                this.word = item
                executePendingBindings()
            }
        }
    }
}