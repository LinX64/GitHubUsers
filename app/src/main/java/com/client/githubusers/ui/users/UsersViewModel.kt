package com.client.githubusers.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.githubusers.data.model.UserItem
import com.client.githubusers.data.repository.UsersRepository
import com.client.githubusers.data.util.NetworkResult.Error
import com.client.githubusers.data.util.NetworkResult.Loading
import com.client.githubusers.data.util.NetworkResult.Success
import com.client.githubusers.data.util.asResult
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class UsersViewModel(
    usersRepository: UsersRepository
) : ViewModel() {

    val users: StateFlow<UsersState> = usersRepository.getUsers()
        .asResult()
        .map { result ->
            when (result) {
                is Loading -> UsersState.Loading
                is Success -> UsersState.Success(result.data)
                is Error -> UsersState.Error(result.exception?.message ?: "An error occurred")
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = UsersState.Loading
        )
}

sealed interface UsersState {
    object Loading : UsersState
    data class Success(val users: List<UserItem>) : UsersState
    data class Error(val message: String) : UsersState
}