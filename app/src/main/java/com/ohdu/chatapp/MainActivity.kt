package com.ohdu.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ohdu.chatapp.page.HomeScreen
import com.ohdu.chatapp.page.MessageScreen
import com.ohdu.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ChatAppTheme {
                ProvideWindowInsets {
                    rememberSystemUiController().setStatusBarColor(
                        MaterialTheme.colors.background,
                        darkIcons = MaterialTheme.colors.isLight
                    )

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "homePage") {
                        composable("homePage") {
                            HomeScreen(navHostController = navController)
                        }
                        composable("chatListPage") {
                            MessageScreen()
                        }
                    }

                }
            }
        }
    }
}

