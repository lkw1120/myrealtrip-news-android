package com.lkw1120.news.utils

import android.util.Log
import com.lkw1120.news.datasource.entity.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import java.util.Collections.sort

class ParserUtil {
    /*
        Jsoup 을 통한 파싱 및 크롤링
     */
    fun parsingRss(xml: String): Flow<News> = flow{

        val doc = Jsoup.parse(xml, "", Parser.xmlParser())
        for(element in doc.select("item"))
        {
            val title = element.select("title").text().trim()
            val pubDate = element.select("pubDate").text().trim()
            val link = element.select("link").text().trim()
            val guid = element.select("guid").text().trim()
            val source = element.select("source").text().trim()
            Log.d("NEWS_LINK", link)
            CertificateUtil().postHttps(link,1000,1000)
            val crawling = Jsoup.connect(link).get()
            val thumbnail =
                crawling.select("meta[property=og:image]").attr("content").trim()
            val description =
                crawling.select("meta[property=og:description]").attr("content").trim()
            val words = getWords(description)
            emit(News(title, pubDate, link, guid, description, source, thumbnail, words))
        }
    }.flowOn(Dispatchers.IO)

    private fun getWords(description: String): List<String> {
        val map:HashMap<String,Int> = hashMapOf()
        for(it in description.split(" ")) {
            if(it.length >= 2) {
                map[it] = if(map.containsKey(it)) map[it]!!+1 else 1
            }
        }
        val keyList = map.keys.toList()
        sort(keyList) { t1, t2 ->
            val op = map[t2]!!.compareTo(map[t1]!!)
            if(op == 0) t1.compareTo(t2)
            else op
        }
        val wordList:MutableList<String> = mutableListOf()
        wordList.addAll(if(keyList.size > 3) keyList.subList(0,3) else keyList)
        return wordList
    }

}
