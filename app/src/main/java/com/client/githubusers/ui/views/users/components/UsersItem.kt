package com.client.githubusers.ui.views.users.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.client.githubusers.data.model.UsersResponse

@Composable
internal fun UsersItem(
    modifier: Modifier = Modifier,
    user: UsersResponse
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
            //Text(text = user[0].login)
        }
    }
}

