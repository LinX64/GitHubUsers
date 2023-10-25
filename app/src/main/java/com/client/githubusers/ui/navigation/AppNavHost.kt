package com.client.githubusers.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.githubusers.ui.views.userDetail.UserDetailRoute
import com.client.githubusers.ui.views.users.UsersRoute

@Composable
internal fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.usersScreen,
        modifier = modifier
    ) {
        usersScreen(navController)
        userDetailScreen()
    }
}

private fun NavGraphBuilder.usersScreen(navController: NavHostController) {
    composable(NavRoutes.usersScreen) {
        UsersRoute(onItemClick = { navController.navigate("${NavRoutes.userDetailScreen}/$it") })
    }
}

private fun NavGraphBuilder.userDetailScreen() {
    composable(
        route = "${NavRoutes.userDetailScreen}/{userName}",
        arguments = listOf(navArgument("userName") { defaultValue = "" })
    ) {
        UserDetailRoute()
    }
}
