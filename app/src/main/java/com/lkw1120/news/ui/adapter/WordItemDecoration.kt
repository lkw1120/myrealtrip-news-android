package com.lkw1120.news.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class WordItemDecoration(
    private val width: Int,
    private val height: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.left = 0
        outRect.right = width
        outRect.top = height
        outRect.bottom = height
    }
}