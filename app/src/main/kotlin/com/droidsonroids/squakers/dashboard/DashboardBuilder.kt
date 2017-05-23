package com.droidsonroids.squakers.dashboard

import com.droidsonroids.squakers.app.AppComponent
import com.droidsonroids.squakers.dashboard.di.DaggerDashboardComponent
import javax.inject.Inject


class DashboardBuilder {

    @Inject lateinit var dashboardRouter: DashboardRouter

    fun build(appComponent: AppComponent) : DashboardRouter {
        val dashboardComponent = DaggerDashboardComponent.builder()
                .appComponent(appComponent)
                .build()

        dashboardComponent.inject(this)
        dashboardRouter.component = dashboardComponent

        return dashboardRouter
    }
}