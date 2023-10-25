package com.client.githubusers.ui.views.users

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.githubusers.ui.views.users.components.SearchBarView
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UsersRoute(
    viewModel: UserSearchViewModel = koinViewModel()
) {
    val searchResultState by viewModel.searchResultState.collectAsStateWithLifecycle()
    UsersScreen(
        searchResultState = searchResultState,
        onSearchClick = viewModel::onSearchClick,
        onClear = viewModel::onClear
    )
}

@Composable
internal fun UsersScreen(
    searchResultState: SearchUiState,
    onSearchClick: (String) -> Unit = {},
    onClear: () -> Unit
) {
    val shouldTheTextBeShown = remember { mutableStateOf(true) }

    SearchBarView(
        searchUiState = searchResultState,
        onSearchClick = onSearchClick,
        isSearchViewActive = { shouldTheTextBeShown.value = !it },
        onClear = onClear
    )

    when (searchResultState) {
        is SearchUiState.Error -> {
            Text(text = "Error ${searchResultState.error}")
        }

        is SearchUiState.Success -> {
            Text(text = "Success ${searchResultState.users}")
        }

        is SearchUiState.Loading -> {
            Text(text = "Loading")
        }

        else -> Unit
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun UsersScreenPreview() {
    UsersScreen(
        searchResultState = SearchUiState.Success(emptyList()),
        onSearchClick = {}
    ) {}
}