package com.droidsonroids.squakers.dashboard

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*

fun onDashboard(func: com.droidsonroids.squakers.dashboard.DashboardRobot.() -> Unit) = com.droidsonroids.squakers.dashboard.DashboardRobot().apply { func() }

class DashboardRobot {

    private val ALL_ITEMS_COUNT = 2
    fun isFabVisible(): com.droidsonroids.squakers.dashboard.DashboardRobot {
        onView(withId(com.droidsonroids.squakers.R.id.floatingActionButton)).check(matches(isDisplayed()))
        return this
    }

    fun isFullListOfServicesVisible() : com.droidsonroids.squakers.dashboard.DashboardRobot {
        onView(withId(com.droidsonroids.squakers.R.id.servicesRecyclerView)).check(matches(isDisplayed()))
        onView(withId(com.droidsonroids.squakers.R.id.servicesRecyclerView)).check { view, noViewFoundException ->
            if (noViewFoundException != null) throw noViewFoundException
            assertThat((view as android.support.v7.widget.RecyclerView).adapter.itemCount, org.hamcrest.Matchers.`is`(ALL_ITEMS_COUNT))
        }
        return this
    }
}