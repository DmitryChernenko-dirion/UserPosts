package biz.dirion.userandposts.data

import biz.dirion.userandposts.data.extensions.toEntity
import biz.dirion.userandposts.data.local.daos.PostDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val postDao: PostDao,
) {

    suspend fun fetch() = withContext(Dispatchers.IO) {
        val list = apiService.getPosts().map { it.toEntity() }
//        postDao.insertAll(*list.toTypedArray())
        list.forEach { postDao.insertAll(it) }
    }
}