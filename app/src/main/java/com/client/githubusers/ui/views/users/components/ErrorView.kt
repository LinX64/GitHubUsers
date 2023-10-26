package com.client.githubusers.ui.views.users.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.client.githubusers.R

@Composable
fun ErrorView() {
    BaseCenterColumn {
        Text(
            text = stringResource(R.string.something_went_wrong),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .semantics { contentDescription = "Something went wrong" }
        )
    }
}