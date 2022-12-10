package biz.dirion.userandposts.data.extensions

import biz.dirion.userandposts.data.PostResponse
import biz.dirion.userandposts.data.UserResponse
import biz.dirion.userandposts.data.local.entities.PostEntity
import biz.dirion.userandposts.data.local.entities.UserEntity

fun PostResponse.toEntity() = PostEntity(
    id = id,
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