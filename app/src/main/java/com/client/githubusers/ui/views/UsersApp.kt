package com.client.githubusers.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.client.githubusers.ui.navigation.AppNavHost
import com.client.githubusers.ui.navigation.AppState
import com.client.githubusers.ui.navigation.rememberAppState

@Composable
internal fun UsersApp(
    appState: AppState = rememberAppState()
) {
    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AppNavigation(
                navController = appState.navController,
                padding = paddingValues
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AppNavigation(
    navController: NavHostController,
    padding: PaddingValues
) {
    AppNavHost(
        navController = navController,
        modifier = Modifier
            .padding(padding)
            .consumeWindowInsets(padding)
    )
}
