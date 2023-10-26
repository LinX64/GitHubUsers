package com.client.githubusers.ui.views.userDetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.githubusers.data.util.StubUtil
import com.client.githubusers.ui.views.userDetail.components.UserDetailContent
import com.client.githubusers.ui.views.users.components.BaseCenterColumn
import com.client.githubusers.ui.views.users.components.LoadingDots
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
    userState: UserDetailUiState
) {
    val shouldShowLoadingDots = userState is UserDetailUiState.Loading
    BaseCenterColumn {
        if (userState is UserDetailUiState.Success) {
            UserDetailContent(user = userState.user)
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
    val getUser = StubUtil.getDummyUserDetail()
    UserDetailScreen(
        userState = UserDetailUiState.Success(
            user = getUser
        )
    )
}