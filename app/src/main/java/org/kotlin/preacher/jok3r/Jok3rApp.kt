package org.kotlin.preacher.jok3r

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.kotlin.preacher.jok3r.di.appModules
import timber.log.Timber

class Jok3rApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@Jok3rApp)
            modules(appModules)
        }
    }

}