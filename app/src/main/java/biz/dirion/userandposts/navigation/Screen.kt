package biz.dirion.userandposts.navigation

sealed class Screen(val route: String) {
    object User : Screen(route = "user")
    object UserPosts : Screen(route = "user_posts/{${Argument.USER_ID}}") {
        fun passArgument(userId: Long) = "user_posts/${userId}"
    }
}