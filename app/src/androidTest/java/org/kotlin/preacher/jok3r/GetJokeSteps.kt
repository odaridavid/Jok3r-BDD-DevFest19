package org.kotlin.preacher.jok3r

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.hamcrest.CoreMatchers.not

class GetJokeSteps {

    @When("^I click on get a joke button")
    fun I_click_on_joke_button()
    {
        onView(withId(R.id.get_joke_button)).perform(click())
    }

    @Then("^I should not see no joke to display text")
    fun I_should_not_see_auth_error()
    {
        onView(withId(R.id.joke_text_view)).check(matches(not(withText(R.string.info_no_joke_loaded))))
    }
}