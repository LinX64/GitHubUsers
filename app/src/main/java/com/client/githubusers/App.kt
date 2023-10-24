package com.client.githubusers

import android.app.Application
import com.client.githubusers.di.appModule
import com.client.githubusers.di.networkModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule, networkModule))
        }
    }
}