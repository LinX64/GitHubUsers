package com.client.githubusers.ui.users

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.githubusers.ui.users.components.UsersItem
import org.koin.compose.koinInject

@Composable
internal fun UsersRoute(
    viewModel: UsersViewModel = koinInject()
) {
    val usersState by viewModel.users.collectAsStateWithLifecycle()
    UsersScreen(
        usersState = usersState
    )
}

@Composable
internal fun UsersScreen(
    modifier: Modifier = Modifier,
    usersState: UsersState
) {
    val state = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        state = state
    ) {
        usersContent(usersState)
    }
}

private fun LazyGridScope.usersContent(usersState: UsersState) {
    when (usersState) {
        is UsersState.Loading -> {
            // TODO: Add loading indicator
        }

        is UsersState.Success -> {
            items(usersState.users.size) { user ->
                UsersItem(user = usersState.users[user])
            }
        }

        is UsersState.Error -> {
            item {
                Text(text = "Error: ${usersState.message}")
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun UsersScreenPreview() {
    UsersScreen(usersState = UsersState.Success(emptyList()))
}