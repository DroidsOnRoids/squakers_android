package com.droidsonroids.toast.reporting

import android.content.Context
import android.os.Build
import com.droidsonroids.squakers.BuildConfig
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.acra.ReportField
import org.acra.collector.CrashReportData
import org.acra.sender.ReportSender
import org.acra.sender.ReportSenderException
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

class HockeySender : ReportSender {
    private val mOkHttpClient: OkHttpClient

    init {
        mOkHttpClient = OkHttpClient.Builder().connectTimeout(TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
                .build()
    }

    private fun createCrashLogString(report: CrashReportData, stacktrace: String): String {
        return """
            Package: ${report[ReportField.PACKAGE_NAME]}
            Version ${report[ReportField.APP_VERSION_CODE]}
            Android: ${report[ReportField.ANDROID_VERSION]}
            Manufacturer: ${Build.MANUFACTURER}
            Model: ${report[ReportField.PHONE_MODEL]}
            Date: ${Date()}
            Stacktrace: $stacktrace""""
    }

    @Throws(ReportSenderException::class)
    override fun send(context: Context, report: CrashReportData) {
        val formEncodingBuilder = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userID", report[ReportField.INSTALLATION_ID].toString())
        val stacktrace = report[ReportField.STACK_TRACE].toString()
        val indexOfSpace = stacktrace.indexOf(' ')
        val indexOfNewLine = stacktrace.indexOf('\n')
        if (indexOfNewLine > indexOfSpace && indexOfSpace > -1) {
            formEncodingBuilder.addFormDataPart("contact", stacktrace.substring(indexOfSpace, indexOfNewLine))
        }
        formEncodingBuilder.addFormDataPart("raw", createCrashLogString(report, stacktrace))
        val request = Request.Builder().url(URL).post(formEncodingBuilder.build()).build()
        try {
            val response = mOkHttpClient.newCall(request).execute()
            if (!response.isSuccessful) {
                throw ReportSenderException("Non-positive status code")
            }
        } catch (e: IOException) {
            throw ReportSenderException("Failed to send report", e)
        }

    }

    companion object {
        private val URL = "https://rink.hockeyapp.net/api/2/apps/{${BuildConfig.HOCKEYAPP_KEY}}/crashes"
        private val TIMEOUT_MILLIS = 20000
    }
}