package biz.dirion.userandposts.data.local.entities

data class UserWithPostsEntity(
    val id: Long,
    val albumId: Long,
    val name: String,
    val url: String,
    val thumbnailUrl: String,
    val postIds: List<Long>
)
