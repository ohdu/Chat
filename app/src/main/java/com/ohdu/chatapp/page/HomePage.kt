package com.ohdu.chatapp.page

import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.ohdu.chatapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.request.ImageRequest
import com.ohdu.chatapp.StatusBar
import com.ohdu.chatapp.bean.FavouritesFriendsBean
import com.ohdu.chatapp.bean.MessageListBean

/**
 * @Author : lcc
 * @CreateData : 2022/5/10 18:15
 * @Description:
 */

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
    var searchKeyWords by rememberSaveable() {
        mutableStateOf("")
    }
    Row(modifier = Modifier.padding(start = 25.dp, end = 20.dp, top = 14.dp)) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .background(Color(0xff1f232f), RoundedCornerShape(12.dp))
                .weight(1f)
                .height(40.dp)
        ) {
            BasicTextField(
                value = searchKeyWords,
                onValueChange = {
                    searchKeyWords = it
                },
                modifier = Modifier
                    .background(Color(0xff1f232f), RoundedCornerShape(12.dp))
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
                                    RoundedCornerShape(12.dp)
                                )
                                .width(40.dp)
                                .height(40.dp)

                        )
                    }
                }
            )
            if (searchKeyWords.isEmpty()) {
                Text(
                    text = "Searching...",
                    color = Color(0xffa5a7ac),
                    modifier = Modifier
                        .padding(end = 8.dp, start = 8.dp)
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 15.dp)
                .background(
                    Color(0xff03a9f1),
                    RoundedCornerShape(12.dp)
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
    val data = mutableListOf(
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
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .height(140.dp)
                        .width(95.dp)
                        .clip(RoundedCornerShape(22.dp))
                ) {

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://img0.baidu.com/it/u=530426417,2082848644&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500")
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.FillBounds,
                        placeholder = painterResource(R.mipmap.ic_favourites_default),
                        error = painterResource(id = R.mipmap.ic_favourites_default),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = data.name,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(bottom = 12.dp, start = 8.dp, end = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }
}


@Composable
fun FriendsList(navHostController: NavHostController) {
    val data = mutableListOf(
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Odeusz Piotrowski", "Will do, super, thank you", "4:23"),
        MessageListBean("Bożenka Malina", "Uploaded file.", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
        MessageListBean("Maciej Kowalski", "maciej.kowalski@email.com", "4:23"),
    )
    LazyColumn {
        item {
            StatusBar()
        }
        item {
            FriendsListTop()
        }
        item {
            SearchFriends()
        }
        item {
            FavouritesFriends()
        }
        item { Spacer(modifier = Modifier.height(26.dp)) }
        itemsIndexed(data) { index, data ->
            Column(modifier = Modifier
                .padding(start = 25.dp, end = 28.dp)
                .clickable {
                    navHostController.navigate("chatListPage")
                }) {
                if (index != 0) {
                    Spacer(modifier = Modifier.height(22.dp))
                }
                Row {
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
                            .width(44.dp)
                            .height(44.dp)
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = data.name,
                            fontSize = 15.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W400
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = data.message,
                            fontSize = 13.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W300
                        )
                    }
                    Text(
                        text = data.time,
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        }
    }
}


@Composable
fun HomeScreen(navHostController: NavHostController) {
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
        FriendsList(navHostController)
    }
}