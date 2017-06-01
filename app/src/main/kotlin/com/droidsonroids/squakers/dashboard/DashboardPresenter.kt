package com.droidsonroids.squakers.dashboard

import com.droidsonroids.squakers.annotation.OpenForTests
import com.droidsonroids.squakers.dashboard.di.DashboardScope
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor
import javax.inject.Inject

@DashboardScope
@OpenForTests
class DashboardPresenter @Inject constructor() {
    @Inject lateinit var view: DashboardView
    private lateinit var interactor: DashboardInteractor

    fun setInteractor(interactor: DashboardInteractor) {
        this.interactor = interactor
    }

    fun showServices(serviceDescriptors: List<ServiceDescriptor>) {
        view.showListOfServices(serviceDescriptors)
    }

    fun start() {
        view.setPresenter(this)
    }
}