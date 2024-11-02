package com.example.feature_auth.ui.model

sealed class AuthEvent {
    object OpenLogin: AuthEvent()
}
