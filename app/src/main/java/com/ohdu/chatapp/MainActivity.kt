package com.ohdu.chatapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ChatAppTheme {
//                val count = remember {
//                    mutableStateOf(100)
//                }
                Log.e("======", "onCreate: ChatAppTheme")
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                ) {


                    Column {
                        Log.e("======", "onCreate: parent")
                    }

                    Column {


                        Box {
                            Text(text = "", color = Color.Red, fontSize = 22.sp,
                                modifier = Modifier.clickable {

                                })
                            Log.e("======", "onCreate: Box")
                        }


                        test()

//                        Button(
//                            onClick = { count.value++ },
//                            modifier = Modifier.size(count.value.dp)
//                        ) {
//                            Text(text = count.value.toString(), color = Color.Red)
//                        }
                    }
                }

//                ProvideWindowInsets {
//                    rememberSystemUiController().setStatusBarColor(
//                        MaterialTheme.colors.background,
//                        darkIcons = MaterialTheme.colors.isLight
//                    )
//
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "homePage") {
//                        composable("homePage") {
//                            HomeScreen(navHostController = navController)
//                        }
//                        composable("chatListPage") {
//                            MessageScreen()
//                        }
//                    }
//
//                }
            }
        }
    }
}

@Composable
fun test() {
    val count = remember {
        mutableStateOf(100)
    }
//    Button(onClick = { count.value++ }) {
//        Text(text = count.value.toString(), color = Color.Red)
//    }
    Row {
        Text(text = "asdfadad")
        Log.e("======", "onCreate: row")

        Button(
            onClick = { count.value++ },
            modifier = Modifier
                .size(count.value.dp)
                .background(Color.Blue)
        ) {
            Text(text = count.value.toString(), color = Color.Red)
        }
    }
}

