package com.droidsonroids.squakers.provider

import com.droidsonroids.squakers.annotation.OpenForTests
import com.droidsonroids.squakers.dashboard.di.DashboardScope
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor
import javax.inject.Inject

@DashboardScope
@OpenForTests
class ServicesProvider @Inject constructor() {
    private val providersMap: HashMap<Int, DedicatedServiceProvider> = HashMap(2)

    init {
        var provider: DedicatedServiceProvider = DribbbleServiceProvider()
        providersMap.put(provider.getDescriptor().nameId, provider)
        provider = MediumServiceProvider()
        providersMap.put(provider.getDescriptor().nameId, provider)
    }

    fun getAllServiceDescriptors(): List<ServiceDescriptor> {
        val list = ArrayList<ServiceDescriptor>()
        providersMap.values.forEach { provider -> list.add(provider.getDescriptor()) }
        return list
    }
}