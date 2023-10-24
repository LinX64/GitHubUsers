package com.client.githubusers.ui.users.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.githubusers.data.model.UserItem

@Composable
internal fun UsersItem(
    modifier: Modifier = Modifier,
    user: UserItem
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .size(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = user.avatarUrl)
        }
    }
}

@Preview
@Composable
private fun UsersItemPreview() {
    val users = UserItem(
        avatarUrl = "",
        eventsUrl = "",
        followersUrl = "",
        followingUrl = "",
        gistsUrl = "",
        gravatarId = "",
        htmlUrl = "",
        id = 0,
        login = "",
        nodeId = "",
        organizationsUrl = "",
        receivedEventsUrl = "",
        reposUrl = "",
        siteAdmin = false,
        starredUrl = "",
        subscriptionsUrl = "",
        type = "",
        url = ""
    )
    UsersItem(user = users)
}