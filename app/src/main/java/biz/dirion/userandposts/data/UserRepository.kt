package biz.dirion.userandposts.data

import biz.dirion.userandposts.data.extensions.toEntity
import biz.dirion.userandposts.data.local.daos.UserDao
import biz.dirion.userandposts.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao,
) {

    suspend fun fetch() {
        val list = apiService.getUsers().map { it.toEntity() }
        userDao.insertAll(*list.toTypedArray())
    }

    fun getAllUserWithPostsCount(): Flow<List<User>> = userDao.getAllUserWithPostsCount().map { list ->
        list.map { entity ->
            entity.run { User(id, name, url, thumbnailUrl, postsCount) }
        }
    }

    fun getUser(userId: Long): Flow<User> = userDao.getUser(userId).map { entity ->
        entity.run { User(id, name, url, thumbnailUrl, postsCount) }
    }
}