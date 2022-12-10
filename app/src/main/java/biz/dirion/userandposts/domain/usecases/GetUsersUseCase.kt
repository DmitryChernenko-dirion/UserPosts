package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.local.daos.UserDao
import biz.dirion.userandposts.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userDao: UserDao,
) {

    fun execute(): Flow<List<User>> = userDao.getAllUserWithPostsCount().map { list ->
        list.map { entity ->
            entity.run { User(id, name, url, thumbnailUrl, postsCount) }
        }
    }
}