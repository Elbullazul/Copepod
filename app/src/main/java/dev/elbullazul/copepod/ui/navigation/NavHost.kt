package dev.elbullazul.copepod.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.elbullazul.copepod.backends.common.Wrapper
import dev.elbullazul.copepod.ui.fragments.views.ActorListView
import dev.elbullazul.copepod.ui.fragments.views.SettingsView
import dev.elbullazul.copepod.ui.fragments.views.PostListView
import dev.elbullazul.copepod.ui.fragments.views.PostView
import dev.elbullazul.copepod.ui.fragments.views.UserView

@Composable
fun CopepodNavHost(navController: NavHostController, startDestination: String, modifier: Modifier, wrapper: Wrapper) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HomeScreen.route) {
            PostListView(
                onThreadClick = { threadId ->
                    navController.navigate("${ThreadScreen.route}/${threadId}")
                },
                onUserClick = { userName ->
                    navController.navigate("${UserScreen.route}/${userName}")
                },
                onGroupClick = { groupId ->
                    navController.navigate("${UserScreen.route}/${groupId}")
                }
            // on post boost
            // on post favorite
            // on post bookmark
            // on post vote
            // on post react
            )
        }

        composable(MagazineListScreen.route) { ActorListView() }
        composable(SettingsScreen.route) { SettingsView() }

        // post view
        composable(
            route = ThreadScreen.routeWithArgs,
            arguments = ThreadScreen.arguments
        ) { navBackStackEntry ->
            val threadId = navBackStackEntry.arguments?.getString(ThreadScreen.threadIdArg)

            PostView(
                threadId = threadId,
                onUserClick = { userName ->
                    navController.navigate("${UserScreen.route}/${userName}")
                }
            )
        }
        composable(
            route = UserScreen.routeWithArgs,
            arguments = UserScreen.arguments
        ) { navBackStackEntry ->
            val userName = navBackStackEntry.arguments?.getString(UserScreen.routeWithArgs)

            UserView(
                userName = userName,
                onThreadClick = { threadId ->
                    navController.navigate("${ThreadScreen.route}/${threadId}")
                }
            )
        }
    }
}