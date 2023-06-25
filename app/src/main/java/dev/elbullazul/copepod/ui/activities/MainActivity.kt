package dev.elbullazul.copepod.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.ui.fragments.common.BottomBar
import dev.elbullazul.copepod.ui.fragments.common.HeaderBar
import dev.elbullazul.copepod.ui.fragments.views.ThreadListView
import dev.elbullazul.copepod.ui.fragments.views.ThreadView
import dev.elbullazul.copepod.ui.fragments.views.UserProfileView
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
    // DEBUG val context = LocalContext.current
    val navController = rememberNavController()

    CopepodTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = { HeaderBar() },
                bottomBar = { BottomBar(navController = navController) }
            ) { contentPadding ->
                NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(contentPadding)) {
                    composable("home") { ThreadListView(threads = TEST_THREADS) }
                    composable("user") {
                        UserProfileView(
                            comments = TEST_COMMENTS,
                            threads = TEST_THREADS,
                            blogs = emptyList()
                        )
                    }
                    composable("thread") { ThreadView(thread = TEST_THREADS[2]) }
                }
            }
        }
    }
}