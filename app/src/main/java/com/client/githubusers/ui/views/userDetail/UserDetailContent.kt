package com.client.githubusers.ui.views.userDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.client.githubusers.R
import com.client.githubusers.data.model.UserDetailResponse
import com.client.githubusers.data.util.StubUtil
import com.client.githubusers.ui.views.userDetail.components.CompanyRow
import com.client.githubusers.ui.views.userDetail.components.FollowersRow
import com.client.githubusers.ui.views.userDetail.components.FollowingRow
import com.client.githubusers.ui.views.userDetail.components.LocationRow

@Composable
internal fun UserDetailContent(
    modifier: Modifier = Modifier,
    user: UserDetailResponse
) {
    val shouldShouldBio = user.bio != null
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TopSection(user, shouldShouldBio)

                CompanyRow(user)

                Spacer(modifier = Modifier.height(8.dp))

                LocationRow(user)

                Spacer(modifier = Modifier.height(8.dp))

                FollowersRow(user)

                Spacer(modifier = Modifier.height(8.dp))

                FollowingRow(user)
            }
        }

        RepositoryCard(modifier, user)
    }
}

@Composable
private fun TopSection(
    user: UserDetailResponse,
    shouldShouldBio: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(user.avatarUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.baseline_account_circle_24),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = user.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )

        if (shouldShouldBio) {
            Text(
                text = user.bio.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun RepositoryCard(
    modifier: Modifier,
    user: UserDetailResponse
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.repositories),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = user.publicRepos.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun UserDetailContentPreview() {
    val getUser = StubUtil.getDummyUserDetail()
    UserDetailScreen(
        userState = UserDetailUiState.Success(
            user = getUser
        )
    )
}