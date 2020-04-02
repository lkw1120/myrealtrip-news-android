package com.lkw1120.news.datasource.entity

import java.io.Serializable

data class News (

	val title : String,
	val pubDate : String,
	val link : String,
	val guid : String,
	val description : String,
	val source: String,
	val thumbnail: String,
	val words: List<String>
): Serializable