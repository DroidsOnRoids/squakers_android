package com.droidsonroids.squakers.dashboard

import com.droidsonroids.squakers.R
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor
import com.droidsonroids.squakers.provider.ServicesProvider
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class DashboardInteractorTest {

    private lateinit var interactor: DashboardInteractor
    private lateinit var servicesProvider: ServicesProvider
    private lateinit var presenter: DashboardPresenter

    @Before
    fun setUp() {
        presenter = mock(DashboardPresenter::class.java)
        servicesProvider = mock(ServicesProvider::class.java)
        interactor = DashboardInteractor()
        interactor.setPresenter(presenter)
        interactor.servicesProvider = servicesProvider
    }

    @Test
    fun shouldGetListOfServicesOnStartup() {
        interactor.start()
        verify(servicesProvider).getAllServiceDescriptors()
    }

    @Test
    fun shouldTellPresenterToShowServicesWhenTheyAreFetched() {
        val services = listOf(ServiceDescriptor(R.string.dribbble_name, R.drawable.dribbble_icon))
        whenever(servicesProvider.getAllServiceDescriptors()).thenReturn(services)
        interactor.start()
        verify(presenter).showServices(services)
    }


}