package com.lkw1120.news

import android.app.Application
import com.lkw1120.news.datasource.entity.News
import com.lkw1120.news.datasource.remote.ApiConnection
import com.lkw1120.news.repository.ApiRepository
import com.lkw1120.news.viewmodel.MainViewModel
import com.lkw1120.news.viewmodel.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

/*
    Koin을 이용하여 의존성 주입
 */
class App: Application() {

    private val networkModule = module {
        single { ApiConnection(applicationContext).getApi() }
    }
    private val repositoryModule = module {
        single { ApiRepository(get(),applicationContext) }
    }
    private val viewModelModule = module {
        viewModel {
            MainViewModel(get())
        }
        viewModel { (news: News) ->
            NewsViewModel(news)
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(networkModule,repositoryModule,viewModelModule))
        }
    }
}