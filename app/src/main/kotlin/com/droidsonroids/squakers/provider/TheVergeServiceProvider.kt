package com.droidsonroids.squakers.provider

import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor

class TheVergeServiceProvider : DedicatedServiceProvider {
    override fun getDescriptor() = ServiceDescriptor(nameId = R.string.theverge_name, imageDrawableId = R.drawable.thevergeicon)

    override fun getFeedProvider(): ServiceFeedProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}