package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.local.daos.PostDao
import biz.dirion.userandposts.domain.models.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postDao: PostDao,
) {

    fun execute(userId: Long): Flow<List<Post>> = postDao.getPostsByUserId(userId).map { list ->
        Timber.d(list.toString())
        list.map { entity ->
            entity.run { Post(postId, userId, title, body) }
        }
    }
}