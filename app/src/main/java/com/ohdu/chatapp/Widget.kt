package com.ohdu.chatapp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsHeight

/**
 * @Author : lcc
 * @CreateData : 2022/5/10 18:16
 * @Description:
 */


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