package biz.dirion.userandposts.ui.userposts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import biz.dirion.userandposts.domain.usecases.GetPostsUseCase
import biz.dirion.userandposts.domain.usecases.GetUserUseCase
import biz.dirion.userandposts.navigation.Argument
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getUserUseCase: GetUserUseCase,
    private val gerUserPostsUseCase: GetPostsUseCase,
) : ViewModel() {
    private var userId = savedStateHandle.get<Long>(Argument.USER_ID) ?: throw IllegalArgumentException()

    var uiState by mutableStateOf(UserPostsUiState())
        private set

    init {
        getUser()
        getUserPosts()
    }

    private fun getUser() = viewModelScope.launch {
        getUserUseCase.execute(userId = userId)
            .collect {
                synchronized(this@UserPostsViewModel) {
                    uiState = uiState.copy(
                        user = it
                    )
                }
            }
    }

    private fun getUserPosts() = viewModelScope.launch {
        gerUserPostsUseCase.execute(userId = userId)
            .collect { list ->
                synchronized(this@UserPostsViewModel) {
                    uiState = uiState.copy(
                        list = list,
                        isEmpty = list.isEmpty()
                    )
                }
            }
    }
}