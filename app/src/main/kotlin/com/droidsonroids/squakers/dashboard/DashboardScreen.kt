package com.droidsonroids.squakers.dashboard

import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.dashboard.list.DashboardItemDecoration
import com.droidsonroids.squakers.dashboard.list.ServiceAdapter
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor
import kotlinx.android.synthetic.main.dashboard_screen.view.*


class DashboardScreen(private val parent: ViewGroup) : FrameLayout(parent.context), DashboardView {
    private val view: View = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_screen, this, true)

    init {
        parent.addView(view)
    }

    private lateinit var presenter: DashboardPresenter

    override fun setPresenter(presenter: DashboardPresenter) {
        this.presenter = presenter
    }

    override fun showListOfServices(serviceDescriptors: List<ServiceDescriptor>) {
        servicesRecyclerView.layoutManager = GridLayoutManager(context, 2)
        servicesRecyclerView.adapter = ServiceAdapter(serviceDescriptors)
        servicesRecyclerView.addItemDecoration(DashboardItemDecoration())
    }

    override fun detachView() {
        parent.removeView(view)
    }
}

interface DashboardView {
    fun setPresenter(presenter: DashboardPresenter)
    fun showListOfServices(serviceDescriptors: List<ServiceDescriptor>)
    fun detachView()
}

