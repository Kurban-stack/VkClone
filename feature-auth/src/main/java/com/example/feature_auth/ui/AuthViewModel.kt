package com.example.feature_auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_auth.ui.model.AuthIntent
import com.example.feature_auth.ui.model.AuthEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private var _event = Channel<AuthEvent>(Channel.BUFFERED)
    val event get() = _event.receiveAsFlow()

    fun sendIntent(intent: AuthIntent) {
        when (intent) {
            is AuthIntent.Login -> {
                viewModelScope.launch {
                    _event.send(AuthEvent.OpenLogin)
                }
            }
        }
    }
}