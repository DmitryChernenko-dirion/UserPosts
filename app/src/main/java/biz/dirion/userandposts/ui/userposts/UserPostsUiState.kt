package biz.dirion.userandposts.ui.userposts

import biz.dirion.userandposts.domain.models.Post
import biz.dirion.userandposts.domain.models.User

data class UserPostsUiState(
    val user: User? = null,
    val list: List<Post> = listOf(),
    val isError: Boolean = false,
    val isEmpty: Boolean = true,
)
