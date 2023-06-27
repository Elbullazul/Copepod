package dev.elbullazul.copepod.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.elbullazul.copepod.ui.fragments.common.BottomBar
import dev.elbullazul.copepod.ui.fragments.common.TopBar
import dev.elbullazul.copepod.ui.fragments.views.BlogListView
import dev.elbullazul.copepod.ui.fragments.views.MagazineListView
import dev.elbullazul.copepod.ui.fragments.views.SettingsView
import dev.elbullazul.copepod.ui.fragments.views.ThreadListView
import dev.elbullazul.copepod.ui.fragments.views.ThreadView
import dev.elbullazul.copepod.ui.helpers.ShowToast
import dev.elbullazul.copepod.ui.navigation.Blogs
import dev.elbullazul.copepod.ui.navigation.Magazines
import dev.elbullazul.copepod.ui.navigation.Overview
import dev.elbullazul.copepod.ui.navigation.PostView
//import dev.elbullazul.copepod.ui.navigation.Screens
import dev.elbullazul.copepod.ui.navigation.Settings
import dev.elbullazul.copepod.ui.theme.CopepodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}
@Composable
fun App() {
    // DEBUG
//    val context = LocalContext.current
    val navController = rememberNavController()

    CopepodTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
//                    TopBar()
                     TopAppBar(title = { Text(text = "copepod") },
                         navigationIcon =
                         {
                             IconButton(onClick = { navController.navigateUp() }) {
                                 Icon(
                                     imageVector = Icons.Filled.ArrowBack,
                                     contentDescription = "back"
                                 )
                             }
                         }
                     )
                 },
                bottomBar = { BottomBar(navController = navController) }
            ) { contentPadding ->
                NavHost(navController = navController, startDestination = Overview.route, modifier = Modifier.padding(contentPadding)) {
                    composable(Overview.route) {
                        ThreadListView(onThreadClick = {
                            threadId ->
                            navController.navigate("thread/${threadId}")
                        })
//                        Overview.view()
                    }
                    composable(Magazines.route) { MagazineListView() }
                    composable(Blogs.route) { BlogListView() }
                    composable(Settings.route) { SettingsView() }

                    composable(
                        route = "${PostView.route}/{${PostView.threadIdArg}}",
                        arguments = PostView.arguments
                    ) { navBackStackEntry->
                        val threadId = navBackStackEntry.arguments?.getString(PostView.threadIdArg)

                        ThreadView(threadId)
                    }

//                    for (navItem in Screens.NavItems) {
//                        composable(navItem.route) { navItem.view() }
//                    }
                }
            }
        }
    }
}