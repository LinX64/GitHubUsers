package com.client.githubusers.ui.views.userDetail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.githubusers.ui.views.userDetail.components.UserDetailContent
import com.client.githubusers.ui.views.users.components.BaseCenterColumn
import com.client.githubusers.ui.views.users.components.LoadingDots
import com.client.githubusers.ui.views.util.ViewUtil
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UserDetailRoute(
    viewModel: UserDetailViewModel = koinViewModel()
) {
    val userState by viewModel.userState.collectAsStateWithLifecycle()
    UserDetailScreen(
        userState = userState
    )
}

@Composable
internal fun UserDetailScreen(
    modifier: Modifier = Modifier,
    userState: UserDetailUiState
) {
    val shouldShowLoadingDots = userState is UserDetailUiState.Loading
    BaseCenterColumn {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .size(250.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 8.dp,
                pressedElevation = 8.dp
            )
        ) {
            if (userState is UserDetailUiState.Success) {
                UserDetailContent(user = userState.user)
            }
        }

        when (userState) {
            is UserDetailUiState.Error -> {
                val error = userState.message
                Text(text = error)
            }

            is UserDetailUiState.Loading -> if (shouldShowLoadingDots) {
                LoadingDots()
            }

            else -> Unit
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun UserDetailScreenPreview() {
    val getUser = ViewUtil.getDummyUserDetail()
    UserDetailScreen(
        userState = UserDetailUiState.Success(
            user = getUser
        )
    )
}