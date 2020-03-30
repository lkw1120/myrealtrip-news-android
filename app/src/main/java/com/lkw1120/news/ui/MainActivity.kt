package com.lkw1120.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.lkw1120.news.R
import com.lkw1120.news.databinding.ActivityMainBinding
import com.lkw1120.news.ui.adapter.NewsItemDecoration
import com.lkw1120.news.ui.adapter.NewsListAdapter
import com.lkw1120.news.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.apply {
            model = viewModel
            lifecycleOwner = this@MainActivity
            newsRefresh.apply {
                setOnRefreshListener {
                    viewModel.refreshRss()
                }
            }
            newsRecyclerView.apply {
                addItemDecoration(
                    NewsItemDecoration(
                        resources.getDimensionPixelSize(R.dimen.item_margin_width),
                        resources.getDimensionPixelSize(R.dimen.item_margin_height))
                )
                val newsListAdapter = NewsListAdapter()
                adapter = newsListAdapter
                subscribeUi(newsListAdapter)
            }
        }
    }

    private fun subscribeUi(adapter: NewsListAdapter) {
        viewModel.newsList.observe(this, Observer {
            adapter.submitList(it)
            binding.newsRefresh.isRefreshing = false
        })
    }
}
