package com.client.githubusers.ui.views.users.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.client.githubusers.R

@Composable
fun EmptyResponseView() {
    BaseCenterColumn {
        Text(
            text = stringResource(R.string.no_results_found),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .height(24.dp)
                .semantics { contentDescription = "No results found" }
        )
    }
}