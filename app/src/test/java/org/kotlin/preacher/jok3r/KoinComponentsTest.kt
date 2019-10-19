package org.kotlin.preacher.jok3r

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.kotlin.preacher.jok3r.data.source.remote.JokesApiService
import org.kotlin.preacher.jok3r.di.appModules

/**
 * Created By David Odari
 * On 18/10/19
 *
 **/
class KoinComponentsTest : AutoCloseKoinTest() {

    private val client: JokesApiService by inject()

    @Before
    fun before() {
        startKoin {
            modules(appModules)
        }
    }

    @Test
    fun tesKoinComponents() {
      assertThat(client).isInstanceOf(JokesApiService::class.java)
    }

}