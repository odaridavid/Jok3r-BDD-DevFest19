package org.kotlin.preacher.jok3r.test

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import junit.framework.TestCase
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    glue = ["org.kotlin.preacher.jok3r.steps"],
    features = ["features"]
)
class CucumberTestCase : TestCase()