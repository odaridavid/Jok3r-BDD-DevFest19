package org.kotlin.preacher.jok3r.data.source

import org.kotlin.preacher.jok3r.data.Result
import org.kotlin.preacher.jok3r.data.models.Joke

interface JokesDataSource {

    suspend fun getJoke(category: String): Result<Joke>

}