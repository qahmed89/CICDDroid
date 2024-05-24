package com.ahmed

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        AppCenter.start(this,"6a8ea143-ec51-4183-8651-e9a04efe87c3",Analytics::class.java,Crashes::class.java)
    }
}