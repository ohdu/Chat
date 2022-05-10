package com.ohdu.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ohdu.chatapp.page.FriendsList
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
                    Surface(
                        color = MaterialTheme.colors.background
                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxSize()
//                        ) {
//                            StatusBar()
//                            FriendsListTop()
//                            SearchFriends()
//                            FavouritesFriends()
//                            FriendsList()
//                        }
                        FriendsList()
                    }
                }
            }
        }
    }
}

