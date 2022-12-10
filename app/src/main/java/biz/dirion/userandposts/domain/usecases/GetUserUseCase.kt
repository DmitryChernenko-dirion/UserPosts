package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.local.daos.UserDao
import biz.dirion.userandposts.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userDao: UserDao,
) {

    fun execute(userId: Long): Flow<User> = userDao.getUser(userId).map { entity ->
        entity.run { User(id, name, url, thumbnailUrl, postsCount) }
    }
}