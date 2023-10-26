package com.client.githubusers.ui.views.userDetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.client.githubusers.R
import com.client.githubusers.data.model.UserDetailResponse

@Composable
fun LocationRow(user: UserDetailResponse) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_location_on_24),
            contentDescription = null
        )

        Text(
            text = user.location,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}