package com.hariofspades.blockchain

import android.app.Application
import android.content.Context
import com.hariofspades.blockchain.inject.feature.listModule
import com.hariofspades.blockchain.inject.presentationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber

class App : Application(), KodeinAware {

    /**
     * created separate modules for each module and feature
     * remote module is included in presentation module
     */
    override val kodein = Kodein.lazy {

        bind<Context>("appContext") with singleton { applicationContext }

        import(presentationModule)

        import(listModule)
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}