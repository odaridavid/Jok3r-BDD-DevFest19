package org.kotlin.preacher.jok3r.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.kotlin.preacher.jok3r.JOKES_BASE_URL
import org.kotlin.preacher.jok3r.data.source.DefaultJokesRepositoryImpl
import org.kotlin.preacher.jok3r.data.source.JokesDataSource
import org.kotlin.preacher.jok3r.data.source.JokesRepository
import org.kotlin.preacher.jok3r.data.source.remote.ApiClient
import org.kotlin.preacher.jok3r.data.source.remote.JokesApiService
import org.kotlin.preacher.jok3r.data.source.remote.JokesRemoteDataSource
import org.kotlin.preacher.jok3r.viewmodels.JokesViewModel

val appModules = module {

    single { ApiClient.getInstance(JOKES_BASE_URL, JokesApiService::class.java) }

    single<JokesDataSource> { JokesRemoteDataSource(jokesApi = get()) }

    single<JokesRepository> {
        DefaultJokesRepositoryImpl(
            jokesDataSource = get()
        )
    }

    viewModel { JokesViewModel(get()) }
}