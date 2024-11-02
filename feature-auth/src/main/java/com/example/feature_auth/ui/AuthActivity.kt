package com.example.feature_auth.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.core.ui.theme.VkCloneTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

private const val PACKAGE_NAME = "com.example.vkclone"
private const val ACTIVITY_PATH = "com.example.vkclone.ui.MainActivity"

class AuthActivity : ComponentActivity() {

    private val authLauncher = VK.login(this) { result: VKAuthenticationResult ->
        when (result) {
            is VKAuthenticationResult.Success -> {
                val intent = Intent().apply {
                    setClassName(PACKAGE_NAME, ACTIVITY_PATH)
                }
                startActivity(intent)
            }
            is VKAuthenticationResult.Failed -> {
                Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (VK.isLoggedIn()) {
            val intent = Intent().apply {
                setClassName(PACKAGE_NAME, ACTIVITY_PATH)
            }
            startActivity(intent)
            finish()
            return
        }
        enableEdgeToEdge()
        setContent {
            VkCloneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AuthScreen(
                        modifier = Modifier.padding(innerPadding),
                        onLoginClick = {
                            authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
                        }
                    )
                }
            }
        }
    }
}