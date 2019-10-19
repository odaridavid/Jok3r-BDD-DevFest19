package org.kotlin.preacher.jok3r.data.source.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private fun setupInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private fun setupOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(setupInterceptor())
            .connectTimeout(300, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .build()
    }

    fun <T> getInstance(baseUrl: String, apiService: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(setupOkhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiService)
    }
}