package com.droidsonroids.squakers.dashboard

import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class DashboardPresenterTest {

    private lateinit var presenter : DashboardPresenter
    private lateinit var view : DashboardView
    private lateinit var interactor : DashboardInteractor

    @Before
    fun setUp() {
        view = mock(DashboardView::class.java)
        interactor = mock(DashboardInteractor::class.java)
        presenter = DashboardPresenter()
        presenter.view = view
        presenter.setInteractor(interactor)
    }

    @Test
    fun shouldShowServicesOnViewWhenInteractorSaysSo() {
        presenter.showServices(emptyList())
        verify(view).showListOfServices(emptyList())
    }
}