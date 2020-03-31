package com.lkw1120.news.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.lkw1120.news.R
import com.lkw1120.news.databinding.ActivityNewsBinding
import com.lkw1120.news.ui.adapter.WordItemDecoration
import com.lkw1120.news.ui.adapter.WordListAdapter
import com.lkw1120.news.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.item_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    private val viewModel by viewModel<NewsViewModel> {
        val bundle = intent.extras!!
        val args = bundle.getSerializable("news")!!
        parametersOf(args)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@NewsActivity, R.layout.activity_news)
        binding.apply {
            model = viewModel
            lifecycleOwner = this@NewsActivity
            newsWordList.addItemDecoration(
                WordItemDecoration(
                    root.resources.getDimensionPixelSize(R.dimen.item_word_list_margin_width),
                    root.resources.getDimensionPixelSize(R.dimen.item_word_list_margin_height)
                )
            )
            val wordListAdapter = WordListAdapter()
            newsWordList.adapter = wordListAdapter
            subscribeUi(wordListAdapter)

            newsWebView.webViewClient = WebViewClient()
            newsWebView.settings.javaScriptEnabled = true

        }
    }

    private fun subscribeUi(adapter: WordListAdapter) {
        viewModel.news.observe(this, Observer {
            adapter.submitList(it.words)
        })
        viewModel.news.observe(this, Observer {
            binding.newsWebView.loadUrl(it.link)
        })
    }
}
