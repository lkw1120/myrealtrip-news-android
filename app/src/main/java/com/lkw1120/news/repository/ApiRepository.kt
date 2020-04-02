package com.lkw1120.news.repository

import android.content.Context
import android.os.Build
import com.lkw1120.news.datasource.entity.News
import com.lkw1120.news.datasource.remote.ApiService
import com.lkw1120.news.utils.ParserUtil
import kotlinx.coroutines.flow.Flow

class ApiRepository(
    private val apiService: ApiService,
    private val context: Context
) {
    private val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        context.resources.configuration.locales.get(0)
    }
    else {
        context.resources.configuration.locale
    }

    suspend fun getLatest(): Flow<News> =
        ParserUtil().parsingRss(apiService.getLatest(locale.language,locale.country,"${locale.country}:${locale.language}"))
}