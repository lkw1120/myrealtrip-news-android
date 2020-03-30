package com.lkw1120.news.ui.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lkw1120.news.R
import com.lkw1120.news.databinding.ItemNewsBinding
import com.lkw1120.news.datasource.entity.News
import com.lkw1120.news.ui.NewsActivity

class NewsListAdapter: ListAdapter<News, RecyclerView.ViewHolder>(DiffCallback<News>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ItemViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ItemViewHolder).bind(item)
    }

    inner class ItemViewHolder(private val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        private val wordListAdapter:WordListAdapter
        init {
            binding.apply {
                itemWordList.addItemDecoration(
                    WordItemDecoration(
                        root.resources.getDimensionPixelSize(R.dimen.item_word_list_margin_width),
                        root.resources.getDimensionPixelSize(R.dimen.item_word_list_margin_height)
                    )
                )
                wordListAdapter = WordListAdapter()
                itemWordList.adapter = wordListAdapter
                root.setOnClickListener {
                    val intent = Intent(it.context, NewsActivity::class.java)
                    val bundle = Bundle()
                    bundle.putSerializable("news", binding.item!!)
                    intent.putExtras(bundle)
                    it.context.startActivity(intent)
                }
            }
        }
        fun bind(item: News) {
            binding.apply {
                this.item = item
                wordListAdapter.submitList(
                    item.words
                )
                executePendingBindings()
            }
        }
    }
}