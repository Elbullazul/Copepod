package dev.elbullazul.copepod.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.elbullazul.copepod.ui.fragments.views.BlogListView
import dev.elbullazul.copepod.ui.fragments.views.ActorListView
import dev.elbullazul.copepod.ui.fragments.views.SettingsView
import dev.elbullazul.copepod.ui.fragments.views.ThreadListView
import dev.elbullazul.copepod.ui.fragments.views.ThreadView
import dev.elbullazul.copepod.ui.fragments.views.UserProfileView

@Composable
fun CopepodNavHost(navController: NavHostController, startDestination: String, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HomeScreen.route) {
            ThreadListView(
                onThreadClick = { threadId ->
                    navController.navigate("${ThreadScreen.route}/${threadId}")
                },
                onUserClick = { userName ->
                    navController.navigate("${UserScreen.route}/${userName}")
                }
            )
//                        Overview.view()
        }
        composable(MagazineListScreen.route) { ActorListView() }
        composable(BlogListScreen.route) { BlogListView() }
        composable(SettingsScreen.route) { SettingsView() }

        // thread view
        composable(
            route = ThreadScreen.routeWithArgs,
            arguments = ThreadScreen.arguments
        ) { navBackStackEntry ->
            val threadId = navBackStackEntry.arguments?.getString(ThreadScreen.threadIdArg)

            ThreadView(
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

            UserProfileView(
                userName = userName,
                onThreadClick = { threadId ->
                    navController.navigate("${ThreadScreen.route}/${threadId}")
                },
                onCommentClick = {
                    // TODO: load comment.root as thread and only show comment as only child
                },
                onBlogClick = {
                    // TODO
                }
            )
        }
    }
}