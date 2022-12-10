package biz.dirion.userandposts.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import biz.dirion.userandposts.navigation.Screen
import biz.dirion.userandposts.navigation.SetupNavGraph

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    SetupNavGraph(
        navController = navController,
        startDestination = Screen.User.route
    )
}