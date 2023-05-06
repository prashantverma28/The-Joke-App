package com.unlimint.thejokeapp

import android.app.Application
import com.unlimint.thejokeapp.di.appModule
import com.unlimint.thejokeapp.di.databaseModule
import com.unlimint.thejokeapp.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheJokeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TheJokeApp)
            modules(remoteModule)
            modules(databaseModule)
            modules(appModule)
        }
    }
}