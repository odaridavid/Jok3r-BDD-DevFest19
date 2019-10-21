package org.kotlin.preacher.jok3r.test

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.mockk.mockk
import org.hamcrest.CoreMatchers.not
import org.kotlin.preacher.jok3r.R
import org.kotlin.preacher.jok3r.ui.jokes.JokesFragment


class GetJokeSteps {

    @Given("I am on the jokes screen")
    fun I_am_on_the_jokes_screen() {
        val navcontroller = mockk<NavController>()
        val scenario =
            launchFragmentInContainer<JokesFragment>(themeResId = R.style.AppTheme)
        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.view!!, navcontroller)
        }
    }

    @When("I click on get a joke button")
    fun I_click_on_the_joke_button() {
        onView(withId(R.id.get_joke_button)).perform(click())
    }

    @Then("I should not see default text but a joke")
    fun I_should_not_see_default_text_but_a_joke() {
        onView(withId(R.id.joke_text_view)).check(matches(not(withText(R.string.info_no_joke_loaded))))
    }
}