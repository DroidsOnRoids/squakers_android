package com.droidsonroids.squakers.provider

import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor


interface DedicatedServiceProvider {
    fun getDescriptor() : ServiceDescriptor
    fun getFeedProvider() : ServiceFeedProvider
}

interface ServiceFeedProvider {

}
