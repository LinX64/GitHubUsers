package com.client.githubusers.ui.users.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.client.githubusers.data.model.UserItem
import com.client.githubusers.data.model.UsersResponse

@Composable
internal fun UsersItem(
    modifier: Modifier = Modifier,
    user: UserItem
) {
    Card(
        modifier = modifier.size(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

        }
    }
}