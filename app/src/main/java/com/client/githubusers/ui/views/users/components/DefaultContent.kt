package com.client.githubusers.ui.views.users.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun DefaultContent() {
    BaseCenterColumn {
        Text(
            modifier = Modifier.semantics { contentDescription = "Search for a user" },
            text = stringResource(R.string.please_enter_a_user_name),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.i_e_john_doe))
    }
}