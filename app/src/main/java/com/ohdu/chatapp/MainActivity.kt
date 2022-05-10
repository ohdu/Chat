package com.ohdu.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ohdu.chatapp.bean.FavouritesFriendsBean
import com.ohdu.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ChatAppTheme {
                ProvideWindowInsets {
                    rememberSystemUiController().setStatusBarColor(
                        Color.Transparent,
                        darkIcons = MaterialTheme.colors.isLight
                    )
                    Surface(
                        color = MaterialTheme.colors.background
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            StatusBar()
                            FriendsListTop()
                            SearchFriends()
                            FavouritesFriends()
                        }
                    }
                }
            }
        }
    }
}


/**
 * 好友列表顶部
 */
@Composable
fun FriendsListTop() {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 35.dp, top = 48.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.mipmap.ic_avatar),
            error = painterResource(id = R.mipmap.ic_avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .width(45.dp)
                .height(45.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "Martina Wolna", fontSize = 27.sp, color = MaterialTheme.colors.primary)
    }
}

@Composable
fun SearchFriends() {
    var searchKeyWords by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.padding(start = 25.dp, end = 20.dp, top = 14.dp)) {
        BasicTextField(
            value = searchKeyWords,
            onValueChange = {
                searchKeyWords = it
            },
            modifier = Modifier
                .background(Color(0xff1f232f), CircleShape.copy(all = CornerSize(12.dp)))
                .weight(1f)
                .height(40.dp),
            singleLine = true,
            textStyle = TextStyle(color = MaterialTheme.colors.primary),
            // 光标颜色
            cursorBrush = SolidColor(Color.White),
            decorationBox = { innerTextField ->
                Row {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(end = 8.dp, start = 8.dp)
                    ) {
                        innerTextField()
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier
                            .background(
                                Color(0xff565e70),
                                CircleShape.copy(all = CornerSize(12.dp))
                            )
                            .width(40.dp)
                            .height(40.dp)

                    )
                }
            }
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 15.dp)
                .background(
                    Color(0xff03a9f1),
                    CircleShape.copy(all = CornerSize(12.dp))
                )
                .width(40.dp)
                .height(40.dp)
        ) {
            Text(
                "+",
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colors.primary
            )
        }

    }
}


@Composable
fun FavouritesFriends() {
    val data = mutableListOf<FavouritesFriendsBean>(
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa"),
        FavouritesFriendsBean("asdfa")
    )
    Text(
        text = "Favourites",
        fontSize = 20.sp,
        color = MaterialTheme.colors.primary,
        fontWeight = FontWeight.W400,
        modifier = Modifier.padding(top = 7.dp, start = 35.dp)
    )
    LazyRow(
        modifier = Modifier.padding(start = 25.dp, top = 10.dp)
    ) {
        items(data) { data ->
            Row {
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .height(110.dp)
                        .width(80.dp)
                ) {
//                Image(painter = , contentDescription = )
                    Text(
                        text = data.name,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }
}

/**
 * 状态栏
 */
@Composable
fun StatusBar() {
    Spacer(
        modifier = Modifier
            .statusBarsHeight()
            .fillMaxWidth()
    )
}