package com.droidsonroids.squakers.dashboard.di

import android.widget.FrameLayout
import com.droidsonroids.squakers.dashboard.DashboardScreen
import com.droidsonroids.squakers.dashboard.DashboardView
import dagger.Module
import dagger.Provides

@Module
class DashboardModule {
    @Provides
    fun provideDashboardView(rootView: FrameLayout): DashboardView {
        return DashboardScreen(rootView)
    }
}