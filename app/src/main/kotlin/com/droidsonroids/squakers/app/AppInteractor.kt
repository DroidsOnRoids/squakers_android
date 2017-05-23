package com.droidsonroids.squakers.app

import javax.inject.Inject


class AppInteractor @Inject constructor() {
    private lateinit var appRouter: AppRouter

    fun setRouter(appRouter: AppRouter) {
        this.appRouter = appRouter
    }

    fun start() {
        appRouter.attachDashboardRiblet()
    }

}