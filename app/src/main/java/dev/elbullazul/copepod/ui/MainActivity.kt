package dev.elbullazul.copepod.ui

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
import dev.elbullazul.copepod.ui.fragments.common.BottomBar
import dev.elbullazul.copepod.ui.fragments.common.TopBar
import dev.elbullazul.copepod.ui.navigation.Overview
import dev.elbullazul.copepod.ui.navigation.Screens
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
                topBar = { TopBar() },
                bottomBar = { BottomBar(navController = navController) }
            ) { contentPadding ->
                NavHost(navController = navController, startDestination = Overview.route, modifier = Modifier.padding(contentPadding)) {
                    for (navItem in Screens.NavItems) {
                        composable(navItem.route) { navItem.view() }
                    }
                }
            }
        }
    }
}