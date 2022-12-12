package biz.dirion.userandposts.data.extensions

import biz.dirion.userandposts.data.PostResponse
import biz.dirion.userandposts.data.UserResponse
import biz.dirion.userandposts.data.local.entities.PostEntity
import biz.dirion.userandposts.data.local.entities.UserEntity
import biz.dirion.userandposts.data.models.UserWithPostsCount
import biz.dirion.userandposts.domain.models.Post
import biz.dirion.userandposts.domain.models.User

fun PostResponse.toEntity() = PostEntity(
    postId = id,
    userId = userId,
    title = title,
    body = body,
)

fun UserResponse.toEntity() = UserEntity(
    id = id,
    albumId = albumId,
    name = name,
    url = url,
    thumbnailUrl = thumbnailUrl,
)

fun UserWithPostsCount.toDomain() = this.run { User(id, name, url, thumbnailUrl, postsCount) }

fun PostEntity.toDomain() = this.run { Post(postId, userId, title, body) }