package org.kotlin.preacher.jok3r

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.kotlin.preacher.jok3r.data.source.JokesRepository
import org.kotlin.preacher.jok3r.ui.jokes.JokesFragment

@RunWith(AndroidJUnit4::class)
@MediumTest
class JokesFragmentTest : AutoCloseKoinTest() {

    //TODO Setup Espresso Idling Resources

    val jokesRepository: JokesRepository by inject()

    @Before
    fun initRepository() {
        stopKoin() // For Some Reason Another Koin Instance is running else Has to be stopped explicitly-> To Be Investigated
        startKoin {
            module {
                single<JokesRepository> { FakeJokeRepository() }
            }
        }
    }

    @Test
    fun clickGetJokeButton_displayAJokeOnSuccess() {
        val navcontroller = mockk<NavController>()
        val scenario =
            launchFragmentInContainer<JokesFragment>(themeResId = R.style.AppTheme)
        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.view!!, navcontroller)
        }
        onView(withId(R.id.joke_text_view)).check(matches(withText(R.string.info_no_joke_loaded)))

        onView(withId(R.id.get_joke_button)).perform(click())

        //TODO Test Refactor
        onView(withId(R.id.joke_text_view)).check(matches(withText("There are only 10 kinds of people in this world: those who know binary and those who don't")))
    }

    @Test
    fun clickGetJokeButton_displayErrorSnackbarOnError() {
        //TODO
    }

    @Test
    fun clickGetJokeButton_displayProgressBarOnWait() {
        //TODO
    }
}