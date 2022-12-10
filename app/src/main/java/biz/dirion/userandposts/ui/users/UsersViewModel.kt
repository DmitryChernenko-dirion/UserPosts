package biz.dirion.userandposts.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import biz.dirion.userandposts.domain.usecases.FetchLocalDataBaseUseCase
import biz.dirion.userandposts.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: FetchLocalDataBaseUseCase
) : ViewModel() {

    init {
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch {
        kotlin.runCatching {
            getUsersUseCase.invoke()
//            getUsersUseCase()
        }.let {
            Timber.d(it.toString())
        }
    }

}