package com.lnight.meditationuicompose.utils.navutils

sealed class Screen(val route: String){
    object HomeScreen: Screen("main_screen")
    object MeditateScreen: Screen("meditate_screen")
    object SleepScreen: Screen("sleep_screen")
    object MusicScreen: Screen("music_screen")

    object ProfileScreen: Screen("profile_screen"){

        fun withArgs(vararg args: String): String{
            return buildString{
                append(route)
                args.forEach { arg ->
                    append("/$arg")
                }
            }
        }
    }
}

