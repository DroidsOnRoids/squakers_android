package com.droidsonroids.squakers.reporting

import android.app.Application

class DebugReporter : CrashReporter {
    override fun initWithApplication(launcherApplication: Application) {
        //no-op
    }

    override fun sendNonFatalException(throwable: Throwable) {
        //no-op
    }
}
