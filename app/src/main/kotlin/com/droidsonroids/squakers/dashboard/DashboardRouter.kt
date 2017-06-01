package com.droidsonroids.squakers.dashboard

import com.droidsonroids.squakers.dashboard.di.DashboardComponent
import javax.inject.Inject


class DashboardRouter @Inject constructor() {

    @Inject lateinit var interactor: DashboardInteractor
    lateinit var component: DashboardComponent

    fun start() {
        interactor.setRouter(this)
        interactor.start()
    }


}