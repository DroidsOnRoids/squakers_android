package com.droidsonroids.toast.reporting

import android.app.Application

interface CrashReporter {
    fun initWithApplication(launcherApplication: Application)
    fun sendNonFatalException(throwable: Throwable)
}
