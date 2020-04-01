package com.lkw1120.news.repository

import android.content.Context
import com.lkw1120.news.datasource.entity.News
import com.lkw1120.news.datasource.remote.ApiService
import com.lkw1120.news.utils.ParserUtil
import kotlinx.coroutines.flow.Flow

class ApiRepository(
    private val apiService: ApiService,
    private val context: Context
) {

    suspend fun getLatest(): Flow<News> =
        ParserUtil().parsingRss(apiService.getLatest("ko","kR","KR:ko"))
}