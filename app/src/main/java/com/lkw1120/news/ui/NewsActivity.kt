package com.lkw1120.news.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lkw1120.news.R
import com.lkw1120.news.databinding.ActivityNewsBinding
import com.lkw1120.news.viewmodel.NewsViewModel
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
            //webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
            //webView.settings.javaScriptEnabled = true
            //webView.settings.loadWithOverviewMode = true
            //webView.loadUrl(viewModel.url.value)
        }
    }
}
