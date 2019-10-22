package org.kotlin.preacher.jok3r.test.runner


import cucumber.api.android.CucumberAndroidJUnitRunner
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    glue = ["org.kotlin.preacher.jok3r.test.steps"],
    features = ["features/"]
)
class CucumberRunner : CucumberAndroidJUnitRunner()