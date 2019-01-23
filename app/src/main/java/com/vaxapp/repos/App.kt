package com.vaxapp.repos

import android.app.Application
import com.vaxapp.repos.di.appModule

import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}
