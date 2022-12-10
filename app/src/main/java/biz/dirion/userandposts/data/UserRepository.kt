package biz.dirion.userandposts.data

import biz.dirion.userandposts.data.extensions.toEntity
import biz.dirion.userandposts.data.local.daos.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao,
) {

    suspend fun fetch() {
        val list = apiService.getUsers().map { it.toEntity() }
        userDao.insertAll(*list.toTypedArray())
    }
}