package biz.dirion.userandposts.ui.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import biz.dirion.userandposts.domain.usecases.FetchDataUseCase
import biz.dirion.userandposts.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val fetchDataUseCase: FetchDataUseCase,
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    var uiState by mutableStateOf(UsersUiState())
        private set

    init {
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch {
        fetchDataUseCase.execute()
            .onSuccess { getUsers() }
            .onFailure { }
    }

    private suspend fun getUsers() {
        getUsersUseCase.execute().collect { list ->
            uiState = uiState.copy(
                list = list,
                isEmpty = list.isEmpty()
            )
        }
    }

}