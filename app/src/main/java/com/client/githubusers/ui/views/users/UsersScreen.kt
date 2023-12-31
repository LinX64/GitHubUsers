package com.client.githubusers.ui.views.users

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.githubusers.ui.views.users.components.DefaultContent
import com.client.githubusers.ui.views.users.components.SearchBarView
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UsersRoute(
    viewModel: UserSearchViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val searchResultState by viewModel.searchResultState.collectAsStateWithLifecycle()
    UsersScreen(
        searchResultState = searchResultState,
        onSearchClick = viewModel::onSearchClick,
        onClear = viewModel::onClear,
        onItemClick = onItemClick
    )
}

@Composable
internal fun UsersScreen(
    searchResultState: SearchUiState,
    onSearchClick: (String) -> Unit = {},
    onClear: () -> Unit,
    onItemClick: (String) -> Unit
) {
    val shouldShowDefaultContent = remember { mutableStateOf(true) }

    SearchBarView(
        searchUiState = searchResultState,
        isSearchBarActive = { shouldShowDefaultContent.value = !it },
        onSearchClick = onSearchClick,
        onClear = onClear,
        onItemClick = onItemClick
    )

    if (shouldShowDefaultContent.value) {
        DefaultContent()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun UsersScreenPreview() {
    UsersScreen(
        searchResultState = SearchUiState.SearchNotReady,
        onSearchClick = {},
        onClear = {},
        onItemClick = {}
    )
}