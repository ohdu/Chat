package com.ohdu.chatapp.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ohdu.chatapp.R
import com.ohdu.chatapp.StatusBar
import com.ohdu.chatapp.bean.MessageBean

/**
 * @Author : lcc
 * @CreateData : 2022/5/11 11:08
 * @Description:
 */

@Composable
fun MessageList() {
    val message = mutableListOf(
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你干嘛呢", true),
        MessageBean("你好", false),
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你干嘛呢", true),
        MessageBean("你好", false),
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你好", false),
        MessageBean("你好", true),
        MessageBean("你好", false),
        MessageBean("你好", true),
    )
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 12.dp)
        ) {
            items(message) { data ->
                Message(message = data.message, isSelf = data.isSelf)
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .background(Color.Red)) {

        }
        MessageInput()
    }
}

@Composable
fun Message(message: String, isSelf: Boolean) {
    val contentAlignment = if (isSelf) Alignment.CenterEnd else Alignment.CenterStart
    val color = if (isSelf) Color(0xff272a35) else Color(0xff373e4e)
    Box(
        contentAlignment = contentAlignment,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = message, color = Color.White, fontSize = 13.sp,
            modifier = Modifier
                .padding(horizontal = 6.dp, vertical = 12.dp)
                .background(color)
                .clip(RoundedCornerShape(14.dp))
        )
    }
}


@Composable
fun MessageInput() {
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
fun MessageScreen() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            StatusBar()
            MessageList()
        }
    }
}