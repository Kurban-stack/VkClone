package com.example.vkclone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.ui.theme.VkCloneTheme
import com.example.core.ui.icons.Icons
import com.example.core.ui.icons.ic24.Home
import com.example.core.ui.icons.ic24.PainterTintedIcon
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkCloneTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf("Главная", "Видео", "Профиль")

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icons.Ic24.PainterTintedIcon() {
                        Icons.Ic24.Home
                    }
                },
                label = { Text(screen) },
                selected = false, // Здесь можно добавить логику для выбора активной вкладки
                onClick = {
                    navController.navigate(screen) {
                        // Удаляем все предыдущие экраны из стека навигации для возврата к Tab Bar
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { }
        composable("videos") { }
        composable("profile") { }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VkCloneTheme {
//        MainScreen()
    }
}