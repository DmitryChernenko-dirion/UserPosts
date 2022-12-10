package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.local.daos.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userDao: UserDao,
) {

}