package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.PostRepository
import biz.dirion.userandposts.data.UserRepository
import biz.dirion.userandposts.data.local.daos.UserDao
import timber.log.Timber
import javax.inject.Inject

class FetchLocalDataBaseUseCase @Inject constructor(
    private val usersRepository: UserRepository,
    private val postsRepository: PostRepository,
    private val userDao: UserDao,
) {

    suspend operator fun invoke() {
        usersRepository.fetch()
        postsRepository.fetch()
        val result = kotlin.runCatching {
            userDao.getAllUsersWithPosts()
        }
        Timber.d(result.toString())
    }

}