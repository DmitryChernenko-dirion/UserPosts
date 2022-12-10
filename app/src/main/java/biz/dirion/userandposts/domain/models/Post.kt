package biz.dirion.userandposts.domain.models

class Post(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String,
)