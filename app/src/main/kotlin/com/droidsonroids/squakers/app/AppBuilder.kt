package com.droidsonroids.squakers.app

import android.widget.FrameLayout
import javax.inject.Inject


class AppBuilder {
    @Inject lateinit var appRouter: AppRouter

    fun build(rootLayout: FrameLayout): AppRouter {
        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(rootLayout))
                .build()

        appComponent.inject(this)
        appRouter.appComponent=appComponent
        return appRouter
    }
}