package com.lnight.meditationuicompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.lnight.meditationuicompose.ui.theme.DeepBlue


@Composable
fun SleepScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
//        BottomMenu(
//            items = listOf(
//                BottomMenuContent("Home", R.drawable.ic_home),
//                BottomMenuContent("Meditate", R.drawable.ic_bubble),
//                BottomMenuContent("Sleep", R.drawable.ic_moon),
//                BottomMenuContent("Music", R.drawable.ic_music),
//                BottomMenuContent("Profile", R.drawable.ic_profile),
//            ), modifier = Modifier.align(Alignment.BottomCenter),
//            initialSelectedItemIndex = 3,
//            navController = null,
//        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Sleep", fontSize = 30.sp)
    }
}