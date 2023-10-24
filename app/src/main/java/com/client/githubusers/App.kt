package com.client.githubusers

import android.app.Application
import com.client.githubusers.di.appModule
import com.client.githubusers.di.networkModule
import com.client.githubusers.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(listOf(appModule, networkModule, repositoryModule))
        }
    }
}