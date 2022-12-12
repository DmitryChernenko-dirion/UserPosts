package biz.dirion.userandposts.domain.usecases

import biz.dirion.userandposts.data.PostRepository
import biz.dirion.userandposts.domain.models.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {

    fun execute(userId: Long): Flow<List<Post>> = postRepository.getPostsByUserId(userId)
}