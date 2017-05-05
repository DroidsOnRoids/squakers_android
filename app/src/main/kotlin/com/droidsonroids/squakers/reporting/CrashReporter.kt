package com.droidsonroids.squakers.reporting

import android.app.Application

interface CrashReporter {
    fun initWithApplication(launcherApplication: Application)
    fun sendNonFatalException(throwable: Throwable)
}
