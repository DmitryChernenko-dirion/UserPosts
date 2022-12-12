package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.PostRepository
import biz.dirion.userandposts.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class FetchDataUseCase @Inject constructor(
    private val usersRepository: UserRepository,
    private val postsRepository: PostRepository,
) {

    suspend fun execute() = withContext(Dispatchers.IO) {
        kotlin
            .runCatching {
                usersRepository.fetch()
                postsRepository.fetch()
            }
            .onSuccess { Timber.d("Data successfully fetched") }
            .onFailure { Timber.e(it) }
    }
}