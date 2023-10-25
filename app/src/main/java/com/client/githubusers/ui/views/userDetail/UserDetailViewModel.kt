package com.client.githubusers.ui.views.userDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.githubusers.data.model.UserDetailResponse
import com.client.githubusers.data.repository.UsersRepository
import com.client.githubusers.data.util.NetworkResult
import com.client.githubusers.data.util.asResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

class UserDetailViewModel(
    private val usersRepository: UsersRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val userName = savedStateHandle.get<String>("userName") ?: ""
    private val _userState = MutableStateFlow<UserDetailUiState>(UserDetailUiState.Loading)
    val userState = _userState.asStateFlow()

    init {
        getUserByName()
    }

    private fun getUserByName() {
        if (userName.isNotEmpty()) {
            usersRepository.getUserDetailsByName(userName)
                .asResult()
                .map {
                    when (it) {
                        is NetworkResult.Loading -> _userState.value = UserDetailUiState.Loading
                        is NetworkResult.Success -> {
                            _userState.value = UserDetailUiState.Success(it.data)
                        }

                        is NetworkResult.Error -> {
                            _userState.value = UserDetailUiState.Error(
                                it.exception?.message ?: "An unexpected error occurred"
                            )
                        }
                    }
                }
                .launchIn(viewModelScope)
        }
    }
}

sealed interface UserDetailUiState {
    object Loading : UserDetailUiState
    data class Success(val user: UserDetailResponse) : UserDetailUiState
    data class Error(val message: String) : UserDetailUiState
}