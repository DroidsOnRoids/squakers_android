package com.droidsonroids.squakers.app

import android.widget.FrameLayout
import dagger.Module
import dagger.Provides

@Module
class AppModule(val rootLayout: FrameLayout) {

    @Provides
    fun provideRootLayout() : FrameLayout {
        return rootLayout
    }
}