package com.client.githubusers.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.client.githubusers.R
import com.client.githubusers.ui.navigation.AppNavHost
import com.client.githubusers.ui.navigation.AppState
import com.client.githubusers.ui.navigation.NavRoutes
import com.client.githubusers.ui.navigation.rememberAppState

@Composable
internal fun UsersApp(
    appState: AppState = rememberAppState()
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            AppTopBar(
                navController = appState.navController,
                currentDestination = appState.currentDestination
            )
        },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            if (currentDestination?.route == NavRoutes.usersScreen) {
                Text(
                    text = stringResource(R.string.github_users),
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = stringResource(R.string.user_detail),
                    fontWeight = FontWeight.Bold
                )
            }
        },
        navigationIcon = {
            if (currentDestination?.route != NavRoutes.usersScreen) {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
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
