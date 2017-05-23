package com.droidsonroids.squakers.provider

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ServicesProviderTest{

    private lateinit var servicesProvider: ServicesProvider

    @Before
    fun setUp() {
        servicesProvider = ServicesProvider()
    }

    @Test
    fun shouldInitiallyRegisterProviders_all2() {
        assertEquals(2, servicesProvider.getAllServiceDescriptors().size)
    }

}