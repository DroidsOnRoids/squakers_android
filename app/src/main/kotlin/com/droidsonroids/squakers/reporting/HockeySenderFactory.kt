package com.droidsonroids.squakers.reporting

import android.content.Context
import org.acra.config.ACRAConfiguration
import org.acra.sender.ReportSender
import org.acra.sender.ReportSenderFactory

class HockeySenderFactory : ReportSenderFactory {
    override fun create(context: Context, config: ACRAConfiguration): ReportSender {
        return HockeySender()
    }
}
