package com.lkw1120.news.datasource.remote

import android.content.Context
import com.lkw1120.news.R
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiConnection(context: Context) {

    private val baseUrl: String = context.getString(R.string.news_feed_url)

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    fun getApi(): ApiService =
        retrofit.create(ApiService::class.java)
}