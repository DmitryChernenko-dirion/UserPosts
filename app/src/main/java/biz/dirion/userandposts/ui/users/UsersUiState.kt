package biz.dirion.userandposts.ui.users

import biz.dirion.userandposts.domain.models.User

data class UsersUiState(
    val list: List<User> = listOf(),
    val isEmpty: Boolean = true,
)