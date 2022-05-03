package com.plcoding.meditationuiyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.plcoding.meditationuiyoutube.navigation.Navigation
import com.plcoding.meditationuiyoutube.ui.BottomMenu
import com.plcoding.meditationuiyoutube.ui.HomeScreen
import com.plcoding.meditationuiyoutube.ui.theme.MeditationUIYouTubeTheme
import com.plcoding.meditationuiyoutube.utils.data.BottomMenuContent

class MainActivity : ComponentActivity() {
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