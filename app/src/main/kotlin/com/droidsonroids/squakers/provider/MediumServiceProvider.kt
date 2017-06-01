package com.droidsonroids.squakers.provider

import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor


class MediumServiceProvider : DedicatedServiceProvider{
    override fun getDescriptor() = ServiceDescriptor(R.string.medium_name, R.drawable.mediumicon)

    override fun getFeedProvider(): ServiceFeedProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}