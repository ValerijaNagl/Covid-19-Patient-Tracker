package com.example.vezbe6.valerija_nagl_rn682018.application

import android.app.Application
import timber.log.Timber

class Projekat1App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}