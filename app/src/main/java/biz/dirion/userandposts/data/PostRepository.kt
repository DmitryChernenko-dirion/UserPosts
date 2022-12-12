package biz.dirion.userandposts.data

import biz.dirion.userandposts.data.extensions.toEntity
import biz.dirion.userandposts.data.local.daos.PostDao
import biz.dirion.userandposts.domain.models.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val postDao: PostDao,
) {

    suspend fun fetch() {
        val list = apiService.getPosts().map { it.toEntity() }
        postDao.insertAll(*list.toTypedArray())
    }

    fun getPostsByUserId(userId: Long) : Flow<List<Post>> = postDao.getPostsByUserId(userId).map { list ->
        Timber.d(list.toString())
        list.map { entity ->
            entity.run { Post(postId, userId, title, body) }
        }
    }
}