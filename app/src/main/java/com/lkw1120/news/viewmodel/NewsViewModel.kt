package com.lkw1120.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkw1120.news.datasource.entity.News

class NewsViewModel(
    news: News
): ViewModel() {

    val news: LiveData<News> = MutableLiveData(news)
}