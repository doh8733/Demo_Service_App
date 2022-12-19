package com.example.demo_service_app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.provider.Telephony

class MyApp : Application() {
    companion object {
        const val CHANNEL_ID = "CHANNEL_ID"
    }

    override fun onCreate() {
        super.onCreate()
        createChannelNotifi()
    }

    private fun createChannelNotifi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Channel service",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
    private fun checkPermissionReadInternet(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val myPackageName = packageName
            if (!Telephony.Sms.getDefaultSmsPackage(this).equals(myPackageName)){

            }
        }
    }
}