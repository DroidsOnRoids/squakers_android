package com.droidsonroids.squakers.dashboard.list

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.droidsonroids.squakers.custom.view.getPixelsFromDp

class DashboardItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View?, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val frameSize = parent.context.resources.getPixelsFromDp(16f)
        outRect.top = frameSize
        outRect.bottom = frameSize
        outRect.left = frameSize
        outRect.right = frameSize
    }
}