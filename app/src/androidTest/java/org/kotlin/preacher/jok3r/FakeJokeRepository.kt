package org.kotlin.preacher.jok3r

import org.kotlin.preacher.jok3r.data.Result
import org.kotlin.preacher.jok3r.data.Success
import org.kotlin.preacher.jok3r.data.models.Category
import org.kotlin.preacher.jok3r.data.models.Joke
import org.kotlin.preacher.jok3r.data.models.JokeType
import org.kotlin.preacher.jok3r.data.models.SingleJoke
import org.kotlin.preacher.jok3r.data.source.JokesRepository


class FakeJokeRepository : JokesRepository {

    //TODO Include Two Part Joke

    private val jokes = mutableListOf(
        SingleJoke(
            Category.PROGRAMMING,
            1,
            JokeType.SINGLE,
            "There are only 10 kinds of people in this world: those who know binary and those who don't"
        )
    )

    override suspend fun getJoke(category: Category): Result<Joke> {
        return Success(jokes[0])
    }

}