package com.droidsonroids.squakers.app

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val application: SquakersApp) {

    @Provides
    fun provideContext() : Context {
        return application.applicationContext
    }
}