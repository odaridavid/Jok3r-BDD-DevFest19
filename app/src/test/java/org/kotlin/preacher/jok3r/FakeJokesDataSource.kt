package org.kotlin.preacher.jok3r

import org.kotlin.preacher.jok3r.data.*
import org.kotlin.preacher.jok3r.data.models.Joke
import org.kotlin.preacher.jok3r.data.source.JokesDataSource

class FakeJokeDataSource(private val joke: Joke? = null) : JokesDataSource {

    override suspend fun getJoke(category: String): Result<Joke> {
        joke?.let {
            return if (it.jokeCategory == category)
                Success(it)
            else Loading
        }
        return Error(InvalidJokeResponseException("Joke not found"))
    }

}