package com.droidsonroids.squakers.dashboard

import android.support.test.rule.ActivityTestRule
import android.view.View
import com.droidsonroids.squakers.app.SquakersActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DashboardScreenTest {

    @get:Rule
    val rule = ActivityTestRule(SquakersActivity::class.java, true, true)

    private lateinit var view: View

    @Before
    fun setUp() {
//        view = DashboardScreen(rule.activity)
//        InstrumentationRegistry.getInstrumentation().runOnMainSync {
//            rule.activity.setContentView(FrameLayout(rule.activity))
//
//        }
    }

    @Test
    fun shouldDisplayEmptyScreen() {
        onDashboard {
            isFabVisible()
        }
    }

    @Test
    fun shouldShowAllServices() {
        onDashboard {
            isFabVisible()
            isFullListOfServicesVisible()
        }
    }
}