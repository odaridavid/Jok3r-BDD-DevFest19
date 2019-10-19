package org.kotlin.preacher.jok3r

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.kotlin.preacher.jok3r.data.Error
import org.kotlin.preacher.jok3r.data.Success
import org.kotlin.preacher.jok3r.data.models.*
import org.kotlin.preacher.jok3r.data.source.DefaultJokesRepositoryImpl

class DefaultJokesRepositoryImplTest {

    private val singleJokeData: Joke = SingleJoke(
        Category.PROGRAMMING.name,
        1,
        JokeType.SINGLE.name,
        "There are only 10 kinds of people in this world: those who know binary and those who don't"
    )
    private val twoPartJokeData: Joke = TwoPartJoke(
        Category.PROGRAMMING.name,
        2,
        JokeType.TWO_PART.name,
        "What do you call a group of 8 Hobbits?",
        "A Hobbyte"
    )
    private lateinit var jokeDataSourceTwoPart: FakeJokeDataSource
    private lateinit var jokeDataSourceSingle: FakeJokeDataSource

    //Classes Under Test for both joke cases
    private lateinit var jokesRepositoryWithTwoPartJoke: DefaultJokesRepositoryImpl
    private lateinit var jokesRepositoryWithSingleJoke: DefaultJokesRepositoryImpl

    @Before
    fun createRepo() {
        jokeDataSourceTwoPart = FakeJokeDataSource(twoPartJokeData)
        jokeDataSourceSingle = FakeJokeDataSource(singleJokeData)

        jokesRepositoryWithSingleJoke = DefaultJokesRepositoryImpl(jokeDataSourceSingle)
        jokesRepositoryWithTwoPartJoke = DefaultJokesRepositoryImpl(jokeDataSourceTwoPart)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getJoke_noJokeLoadedFromSource() {
        runBlockingTest {
            val nullJokeSource = FakeJokeDataSource()
            val jokesRepo = DefaultJokesRepositoryImpl(nullJokeSource)
            assertThat(jokesRepo.getJoke(Category.PROGRAMMING.name) is Error).isTrue()
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getJoke_jokeLoadedIsSingleJoke() {
        runBlockingTest {
            val singleJoke = jokesRepositoryWithSingleJoke.getJoke(Category.PROGRAMMING.name) as Success
            assertThat(singleJoke.data).isEqualTo(singleJokeData)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getJoke_jokeLoadedIsTwoPartJoke() {
        runBlockingTest {
            val twoPartJoke =
                jokesRepositoryWithTwoPartJoke.getJoke(Category.PROGRAMMING.name) as Success
            assertThat(twoPartJoke.data).isEqualTo(twoPartJokeData)
        }
    }

    @ExperimentalCoroutinesApi
    @Test(expected = IllegalStateException::class)
    fun getJoke_throwExceptionOnInvalidArguments() {
        runBlockingTest {
            //Will Throw an exception due to mismatching categories
            jokesRepositoryWithTwoPartJoke.getJoke(Category.MISC.name)
        }
    }


}