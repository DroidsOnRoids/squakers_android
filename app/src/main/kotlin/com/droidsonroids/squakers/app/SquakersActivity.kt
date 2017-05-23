package com.droidsonroids.squakers.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout


class SquakersActivity : AppCompatActivity() {

    companion object {
        lateinit var appRouter: AppRouter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this)
        setContentView(frameLayout)
        initAppComponent(frameLayout)
    }

    private fun initAppComponent(frameLayout: FrameLayout) {
        appRouter = AppBuilder().build(frameLayout)
        appRouter.start()
    }
}