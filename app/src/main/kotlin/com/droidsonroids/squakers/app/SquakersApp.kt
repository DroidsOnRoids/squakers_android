package com.droidsonroids.squakers.app

import android.app.Application
import com.droidsonroids.squakers.BuildConfig
import com.droidsonroids.toast.reporting.AcraHockeyReporter
import com.droidsonroids.toast.reporting.CrashReporter
import com.droidsonroids.toast.reporting.DebugReporter
import com.droidsonroids.toast.reporting.HockeySenderFactory
import org.acra.ReportField
import org.acra.annotation.ReportsCrashes

@ReportsCrashes(
        reportSenderFactoryClasses = arrayOf(HockeySenderFactory::class),
        deleteOldUnsentReportsOnApplicationStart = false,
        sendReportsAtShutdown = false,
        customReportContent = arrayOf(
                ReportField.PACKAGE_NAME, ReportField.APP_VERSION_CODE, ReportField.ANDROID_VERSION,
                ReportField.PHONE_MODEL, ReportField.STACK_TRACE, ReportField.CUSTOM_DATA,
                ReportField.INSTALLATION_ID))
class SquakersApp : Application() {


    private lateinit var crashReporter: CrashReporter

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCrashReporter()
        initAppComponent()
    }

    private fun initCrashReporter() {
        if (BuildConfig.CRASH_REPORTING_ENABLED) {
            crashReporter = AcraHockeyReporter()
        } else {
            crashReporter = DebugReporter()
        }
        crashReporter.initWithApplication(this)
    }

    private fun initAppComponent() {
//        appComponent = DaggerAppComponent.builder()
//                .appModule(AppModule(this))
//                .build()
    }
}