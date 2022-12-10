package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.local.daos.PostDao
import biz.dirion.userandposts.domain.models.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPostsByUserIdUseCase @Inject constructor(
    private val postDao: PostDao,
) {

    fun execute(userId: Long): Flow<List<Post>> = postDao.getPostsByUserId(userId).map {
        it.map { entity ->
            Post(
                id = entity.id,
                userId = entity.userId,
                title = entity.title,
                body = entity.body,
            )
        }
    }
}