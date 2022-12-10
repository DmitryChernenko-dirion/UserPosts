package biz.dirion.userandposts.data.models

data class UserWithPostsCount(
    val id: Long,
    val albumId: Long,
    val name: String,
    val url: String,
    val thumbnailUrl: String,
    val postsCount: Long,
)
