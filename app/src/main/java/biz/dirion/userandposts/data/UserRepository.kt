package biz.dirion.userandposts.data

import biz.dirion.userandposts.data.extensions.toEntity
import biz.dirion.userandposts.data.local.daos.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao,
) {

    suspend fun fetch() = withContext(Dispatchers.IO) {
        val list = apiService.getUsers().map { it.toEntity() }
        list.forEach { userDao.insertAll(it) }
//        userDao.insertAll(*list.toTypedArray())
    }

}