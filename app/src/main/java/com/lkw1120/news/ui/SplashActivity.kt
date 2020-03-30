package com.lkw1120.news.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.lifecycleScope
import com.lkw1120.news.R
import com.lkw1120.news.databinding.ActivitySplashBinding
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivitySplashBinding>(this,R.layout.activity_splash)
        this.lifecycleScope.launch {
            delay(1300)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        }
    }
}
