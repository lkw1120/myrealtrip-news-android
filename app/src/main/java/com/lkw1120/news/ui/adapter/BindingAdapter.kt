package com.lkw1120.news.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
/*
    Glide 를 통한 이미지 로딩
 */
@BindingAdapter("app:thumbnail")
fun bindingThumbnail(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .thumbnail(0.1f)
        .centerCrop()
        .into(view)
}