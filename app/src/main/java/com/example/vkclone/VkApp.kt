package com.example.vkclone

import android.app.Application
import android.content.Intent
import com.example.feature_auth.ui.AuthActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VkApp : Application() {
    override fun onCreate() {
        super.onCreate()
        VK.initialize(this)
        VK.addTokenExpiredHandler(tokenTracker)
    }
    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            val intent = Intent(this@VkApp, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            this@VkApp.startActivity(intent)
        }
    }
}
