package com.lnight.meditationuicompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lnight.meditationuicompose.ui.*
import com.lnight.meditationuicompose.utils.navutils.Screen

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){

        composable(Screen.HomeScreen.route){
            HomeScreen()
        }
        composable(Screen.MeditateScreen.route){
            MeditateScreen()
        }
        composable(Screen.SleepScreen.route){
            SleepScreen()
        }
        composable(Screen.MusicScreen.route){
            MusicScreen()
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen()
        }

    }

}