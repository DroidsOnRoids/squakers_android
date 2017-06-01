package com.droidsonroids.squakers.dashboard.list

import android.content.Context
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.custom.view.getPixelsFromDp


class ServiceItemLayout(context: Context) : CardView(context) {
    init {
        radius = resources.getPixelsFromDp(10f).toFloat()
        LayoutInflater.from(context).inflate(R.layout.service_item, this, true)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}