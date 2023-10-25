package com.client.githubusers.ui.views.users

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.githubusers.data.model.UsersResponse
import com.client.githubusers.data.repository.UsersRepository
import com.client.githubusers.data.util.NetworkResult
import com.client.githubusers.data.util.asResult
import com.client.githubusers.domain.UserSearchUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class UserSearchViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val usersRepository: UsersRepository,
    private val userSearchUseCase: UserSearchUseCase
) : ViewModel() {

    private val searchQuery = savedStateHandle.getStateFlow(SEARCH_QUERY, "")

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val searchResultState: StateFlow<SearchUiState> = searchQuery
        .debounce(1000L)
        .distinctUntilChanged()
        .filter { it.length >= 2 }
        .flatMapLatest {
            if (it.isEmpty()) flowOf(SearchUiState.EmptyQuery) else makeTheCall(it)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SearchUiState.EmptyQuery
        )

    private fun makeTheCall(query: String): Flow<SearchUiState> {
        usersRepository.getUsers()
            .asResult()
            .map { mapToUiState(query, it) }
            .launchIn(viewModelScope)
        return flowOf(SearchUiState.Loading)
    }

    private fun mapToUiState(
        query: String,
        result: NetworkResult<List<UsersResponse>>
    ) =
        when (result) {
            is NetworkResult.Loading -> SearchUiState.Loading
            is NetworkResult.Success -> {
                if (result.data.isEmpty()) SearchUiState.Error("Empty response")
                else handleUsersResponse(query, result.data)
            }

            is NetworkResult.Error -> SearchUiState.Error(
                result.exception?.message ?: "An error occurred"
            )
        }

    private fun handleUsersResponse(
        query: String,
        usersResponse: List<UsersResponse>
    ): SearchUiState {
        val filteredUsers = userSearchUseCase(query = query, users = usersResponse)
        return if (filteredUsers.isEmpty()) SearchUiState.EmptyResponse
        else {
            val users = filteredUsers.map { it.login }
            println("Users: $users")
            SearchUiState.Success(users)
        }
    }

    fun onSearchClick(myQuery: String) {
        savedStateHandle[SEARCH_QUERY] = myQuery
    }

    fun onClear() {
        savedStateHandle[SEARCH_QUERY] = ""
    }
}

sealed interface SearchUiState {
    object Loading : SearchUiState
    object EmptyQuery : SearchUiState
    object EmptyResponse : SearchUiState
    object SearchNotReady : SearchUiState
    data class Success(val users: List<String>) : SearchUiState
    data class Error(val error: String) : SearchUiState
}

private const val SEARCH_QUERY = "searchQuery"