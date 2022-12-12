package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.UserRepository
import biz.dirion.userandposts.domain.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {

    fun execute(): Flow<List<User>> = userRepository.getAllUserWithPostsCount()
}