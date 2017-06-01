package com.droidsonroids.squakers.app

import android.widget.FrameLayout
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(appBuilder: AppBuilder)

    fun provideFrameLayout() : FrameLayout
}