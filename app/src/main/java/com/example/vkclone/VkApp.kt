package com.example.vkclone

import android.app.Application
import com.vk.api.sdk.VK
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VkApp : Application() {
    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
    }
}
