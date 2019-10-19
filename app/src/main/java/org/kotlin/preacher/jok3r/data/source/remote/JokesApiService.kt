package org.kotlin.preacher.jok3r.data.source.remote

import org.kotlin.preacher.jok3r.BuildConfig
import org.kotlin.preacher.jok3r.data.models.Category
import org.kotlin.preacher.jok3r.data.models.Joke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface JokesApiService {

    @GET("category/{category_name}")
    suspend fun getAJoke(
        @Header("X-RapidAPI-Key") apiKey: String = BuildConfig.JOKES_KEY,
        @Path("category_name") category: String
    ): Response<Joke>
}