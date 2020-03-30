package com.lkw1120.news.viewmodel

import androidx.lifecycle.*
import com.lkw1120.news.datasource.entity.News
import com.lkw1120.news.repository.ApiRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val apiRepository: ApiRepository
) : ViewModel() {

    val newsList: MutableLiveData<List<News>> = MutableLiveData()

    init {
        refreshRss()
    }

    fun refreshRss() {
        viewModelScope.launch {
            val list = mutableListOf<News>()
            apiRepository.getLatest().collect {
                list.add(it)
                val items = mutableListOf<News>()
                items.addAll(list)
                newsList.postValue(items)
            }
        }
    }
}
