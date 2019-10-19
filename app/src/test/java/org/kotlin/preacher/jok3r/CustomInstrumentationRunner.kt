package org.kotlin.preacher.jok3r

import android.os.Bundle
import androidx.test.runner.MonitoringInstrumentation



/**
 * Created By David Odari
 * On 19/10/19
 *
 **/
class CustomInstrumentationRunner : MonitoringInstrumentation() {
    private val instrumentationCore = CucumberInstrumentationCore(this)
    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)

        instrumentationCore.create(arguments)
        start()
    }

    override fun onStart() {
        super.onStart()
        waitForIdleSync()
        instrumentationCore.start()
    }
}