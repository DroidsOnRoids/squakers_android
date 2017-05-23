package com.droidsonroids.squakers.dashboard.di

import com.droidsonroids.squakers.app.AppComponent
import com.droidsonroids.squakers.dashboard.DashboardBuilder
import dagger.Component

@DashboardScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(DashboardModule::class))
interface DashboardComponent {
    fun inject(dashboardBuilder: DashboardBuilder)
}