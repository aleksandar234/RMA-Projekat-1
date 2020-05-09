package com.example.projekat1.model

import android.app.Application
import timber.log.Timber

class TimberClass : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}