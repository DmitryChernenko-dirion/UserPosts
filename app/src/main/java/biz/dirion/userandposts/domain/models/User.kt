package biz.dirion.userandposts.domain.models

class User(
    val id: Long,
    val name: String,
    val url: String,
    val thumbnailUrl: String,
    val postsCount: Long
)