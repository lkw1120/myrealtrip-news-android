package com.lkw1120.news.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("rss?")
    suspend fun getLatest(@Query("hl") hl: String,
                  @Query("gl") gl: String,
                  @Query("ceid") ceid: String): String

}