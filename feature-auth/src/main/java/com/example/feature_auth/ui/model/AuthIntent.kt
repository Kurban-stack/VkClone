package com.example.feature_auth.ui.model

sealed class AuthIntent {
    object Login : AuthIntent()
}
