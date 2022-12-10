package biz.dirion.userandposts.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import biz.dirion.userandposts.ui.userposts.UserPostsScreen
import biz.dirion.userandposts.ui.users.UsersScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = Screen.User.route) { backStackEntry ->
            UsersScreen(
                onUserClick = { user ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                        navController.navigate(Screen.UserPosts.passArgument(userId = user.id))
                    }
                }
            )
        }

        composable(
            route = Screen.UserPosts.route,
            arguments = listOf(
                navArgument(Argument.USER_ID) { type = NavType.LongType }
            ),
        ) {
            UserPostsScreen()
        }

    }
}