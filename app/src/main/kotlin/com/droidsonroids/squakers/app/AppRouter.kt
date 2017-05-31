package com.droidsonroids.squakers.app

import com.droidsonroids.squakers.dashboard.DashboardBuilder
import com.droidsonroids.squakers.dashboard.DashboardRouter
import javax.inject.Inject

class AppRouter @Inject constructor(val interactor: AppInteractor) {

    lateinit var appComponent: AppComponent
    private lateinit var dashboardRouter: DashboardRouter

    fun start() {
        interactor.setRouter(this)
        interactor.start()
    }

    fun attachDashboard() {
        dashboardRouter = DashboardBuilder().build(appComponent)
        dashboardRouter.start()
    }
}
