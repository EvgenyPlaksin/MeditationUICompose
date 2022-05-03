package com.plcoding.meditationuiyoutube.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.meditationuiyoutube.ui.*
import com.plcoding.meditationuiyoutube.utils.navutils.Screen

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