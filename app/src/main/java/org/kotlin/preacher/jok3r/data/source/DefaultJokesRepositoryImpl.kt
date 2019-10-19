package org.kotlin.preacher.jok3r.data.source

import org.kotlin.preacher.jok3r.data.Error
import org.kotlin.preacher.jok3r.data.Result
import org.kotlin.preacher.jok3r.data.Success
import org.kotlin.preacher.jok3r.data.models.Joke
import org.kotlin.preacher.jok3r.data.models.SingleJoke
import org.kotlin.preacher.jok3r.data.models.TwoPartJoke
import timber.log.Timber

//TODO Load From Preferences
class DefaultJokesRepositoryImpl(private val jokesDataSource: JokesDataSource) :
    JokesRepository {

    override suspend fun getJoke(category: String): Result<Joke> =
        when (val joke = jokesDataSource.getJoke(category)) {
            is Error -> {
                Timber.d(joke.exception)
                joke
            }
            is Success -> {
                when (joke.data.jokeType) {
                    "single" -> {
                        val singleJoke = SingleJoke(
                            category = joke.data.jokeCategory,
                            id = joke.data.jokeId,
                            type = joke.data.jokeType,
                            joke = joke.data.singleJoke!!
                        )
                        Success(singleJoke)
                    }
                    "twopart" -> {
                        val twoPartJoke = TwoPartJoke(
                            category = joke.data.jokeCategory,
                            id = joke.data.jokeId,
                            type = joke.data.jokeType,
                            setup = joke.data.twoPartsetup!!,
                            delivery = joke.data.twoPartdelivery!!
                        )
                        Success(twoPartJoke)
                    }
                    else -> throw IllegalStateException(joke.data.jokeType)
                }
            }
            else -> throw IllegalStateException()
        }


}