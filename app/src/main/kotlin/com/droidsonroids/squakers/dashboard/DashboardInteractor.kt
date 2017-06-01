package com.droidsonroids.squakers.dashboard

import com.droidsonroids.squakers.annotation.OpenForTests
import com.droidsonroids.squakers.dashboard.di.DashboardScope
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor
import com.droidsonroids.squakers.provider.ServicesProvider
import javax.inject.Inject

@DashboardScope
@OpenForTests
class DashboardInteractor @Inject constructor() {

    @Inject lateinit var servicesProvider: ServicesProvider
    @Inject lateinit var presenter: DashboardPresenter
    private var router: DashboardRouter? = null

    fun setRouter(dashboardRouter: DashboardRouter){
        this.router = router
    }

    fun start() {
        presenter.setInteractor(this)
        presenter.start()
        onServicesFetched(servicesProvider.getAllServiceDescriptors())
    }

    fun onServicesFetched(serviceDescriptors: List<ServiceDescriptor>) {
        presenter.showServices(serviceDescriptors)
    }
}