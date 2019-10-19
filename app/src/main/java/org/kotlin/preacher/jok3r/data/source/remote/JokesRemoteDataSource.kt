package org.kotlin.preacher.jok3r.data.source.remote

import org.kotlin.preacher.jok3r.data.Error
import org.kotlin.preacher.jok3r.data.InvalidJokeResponseException
import org.kotlin.preacher.jok3r.data.Result
import org.kotlin.preacher.jok3r.data.Success
import org.kotlin.preacher.jok3r.data.models.Joke
import org.kotlin.preacher.jok3r.data.source.JokesDataSource

class JokesRemoteDataSource(private val jokesApi: JokesApiService) : JokesDataSource {

    override suspend fun getJoke(category: String): Result<Joke> {
        val response = jokesApi.getAJoke(category = category)
        val responseBody = response.body()
        return if (response.isSuccessful && responseBody != null) {
            Success(responseBody)
        } else Error(InvalidJokeResponseException("Couldn't Load The Joke"))
    }

}