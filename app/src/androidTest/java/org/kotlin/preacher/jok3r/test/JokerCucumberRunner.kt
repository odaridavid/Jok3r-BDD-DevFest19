package org.kotlin.preacher.jok3r.test

import cucumber.api.android.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"]
)
@Suppress("UNUSED")
class JokerCucumberRunner : CucumberAndroidJUnitRunner() {

    override fun onStart() {
        super.onStart()
        waitForIdleSync()
    }

}