package biz.dirion.userandposts.data

import biz.dirion.userandposts.data.extensions.toEntity
import biz.dirion.userandposts.data.local.daos.PostDao
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val postDao: PostDao,
) {

    suspend fun fetch() {
        val list = apiService.getPosts().map { it.toEntity() }
        postDao.insertAll(*list.toTypedArray())
    }
}