package com.droidsonroids.squakers.provider

import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor

class RedditServiceProvider : DedicatedServiceProvider {
    override fun getDescriptor() = ServiceDescriptor(nameId = R.string.reddit_name, imageDrawableId = R.drawable.redditicon)

    override fun getFeedProvider(): ServiceFeedProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}