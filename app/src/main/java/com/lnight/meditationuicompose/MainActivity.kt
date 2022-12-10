package com.lnight.meditationuicompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.lnight.meditationuicompose.navigation.Navigation
import com.lnight.meditationuicompose.ui.BottomMenu
import com.lnight.meditationuicompose.ui.theme.MeditationUIYouTubeTheme
import com.lnight.meditationuicompose.utils.data.BottomMenuContent

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {

                val navController = rememberNavController()

               Scaffold(
                   bottomBar = {

                       BottomMenu(
                           items = listOf(
                               BottomMenuContent("Home", R.drawable.ic_home),
                               BottomMenuContent("Meditate", R.drawable.ic_bubble),
                               BottomMenuContent("Sleep", R.drawable.ic_moon),
                               BottomMenuContent("Music", R.drawable.ic_music),
                               BottomMenuContent("Profile", R.drawable.ic_profile)
                           ),
                           navController = navController
                       )
                   }
               ) {
                   Navigation(navController = navController)
               }
            }
        }
    }
}