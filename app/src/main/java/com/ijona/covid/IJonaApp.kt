package com.ijona.covid

import android.app.Application
import com.ijona.covid.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class IJonaApp: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@IJonaApp)
            modules(listOf(
                appModule,
                networkModule,
                repositoryModule,
                viewModelModule,
                databaseModule
            ))

        }

    }
}