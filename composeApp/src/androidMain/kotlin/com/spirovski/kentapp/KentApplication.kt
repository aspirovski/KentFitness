package com.spirovski.kentapp

import android.app.Application
import com.spirovski.kentapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class KentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin { androidContext(this@KentApplication) }
    }
}