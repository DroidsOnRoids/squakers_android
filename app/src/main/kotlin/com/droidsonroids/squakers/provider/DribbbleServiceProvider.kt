package com.droidsonroids.squakers.provider

import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor


class DribbbleServiceProvider : DedicatedServiceProvider{
    override fun getDescriptor() = ServiceDescriptor(nameId = R.string.dribbble_name, imageDrawableId = R.drawable.dribbble_icon)

    override fun getFeedProvider(): ServiceFeedProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}