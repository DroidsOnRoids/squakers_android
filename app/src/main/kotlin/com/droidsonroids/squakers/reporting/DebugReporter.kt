package com.droidsonroids.toast.reporting

import android.app.Application
import com.droidsonroids.toast.reporting.CrashReporter

class DebugReporter : CrashReporter {
    override fun initWithApplication(launcherApplication: Application) {
        //no-op
    }

    override fun sendNonFatalException(throwable: Throwable) {
        //no-op
    }
}
