package io.vinicius.common

import android.app.Application
import io.vinicius.common.di.commonModule
import io.vinicius.common.di.serviceModule
import io.vinicius.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging
        setupTimber()

        // Dependency Injection
        setupKoin()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)

            modules(
                commonModule,
                serviceModule,
                viewModelModule
            )
        }
    }
}