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
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.ui.fragments.common.BottomBar
import dev.elbullazul.copepod.ui.navigation.CopepodNavHost
import dev.elbullazul.copepod.ui.navigation.HomeScreen
import dev.elbullazul.copepod.ui.theme.CopepodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { App() }
    }
}
@Composable
fun App() {
    val navController = rememberNavController()

    CopepodTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
//                    TopBar()
                     TopAppBar(title = { Text(text = stringResource(R.string.app_name)) },
                         navigationIcon = {
//                             if (navController.previousBackStackEntry != null) {
                                 IconButton(onClick = { navController.navigateUp() }) {
                                     Icon(
                                         imageVector = Icons.Filled.ArrowBack,
                                         contentDescription = "back"
                                     )
                                 }
//                             } else { null }
                         }
                     )
                 },
                bottomBar = { BottomBar(navController = navController) }
            ) { contentPadding ->
                CopepodNavHost(navController, HomeScreen.route, Modifier.padding(contentPadding))
            }
        }
    }
}