package com.droidsonroids.squakers.reporting

import android.app.Application
import org.acra.ACRA

class AcraHockeyReporter : CrashReporter {
    override fun initWithApplication(launcherApplication: Application) {
        ACRA.init(launcherApplication)
    }

    override fun sendNonFatalException(throwable: Throwable) {
        ACRA.getErrorReporter().handleException(throwable)
    }
}
