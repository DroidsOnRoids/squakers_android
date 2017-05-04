package com.droidsonroids.toast.reporting

import android.app.Application
import org.acra.ACRA
import com.droidsonroids.toast.reporting.CrashReporter

class AcraHockeyReporter : CrashReporter {
    override fun initWithApplication(launcherApplication: Application) {
        ACRA.init(launcherApplication)
    }

    override fun sendNonFatalException(throwable: Throwable) {
        ACRA.getErrorReporter().handleException(throwable)
    }
}
