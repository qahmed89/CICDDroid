package com.ahmed

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        AppCenter.start(this,"b3029dbb-ff3e-4fc2-8d95-f035dd219d9b",Analytics::class.java,Crashes::class.java)
    }
}