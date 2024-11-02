package com.example.feature_auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.ui.theme.VkCloneTheme
import com.example.feature_auth.ui.model.AuthEvent
import com.example.feature_auth.ui.model.AuthIntent

@Composable
fun AuthScreen(
    modifier: Modifier,
    onLoginClick: () -> Unit,
) {
    val viewModel = viewModel<AuthViewModel>()
    val event by viewModel.event.collectAsStateWithLifecycle(null)

    AuthScreenContent(
        modifier = modifier,
        onLoginClick = { viewModel.sendIntent(AuthIntent.Login) }
    )

    LaunchedEffect(event) {
        when (event) {
            AuthEvent.OpenLogin -> {
                onLoginClick()
            }

            else -> {}
        }
    }
}

@Composable
private fun AuthScreenContent(
    modifier: Modifier,
    onLoginClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(VkCloneTheme.dimens.mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onLoginClick) {
            Text("Войти с VK ID")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAuthScreen() {
    AuthScreenContent(
        modifier = Modifier.fillMaxSize(),
        onLoginClick = {},
    )
}

