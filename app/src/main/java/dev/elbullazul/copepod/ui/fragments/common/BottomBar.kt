package dev.elbullazul.copepod.ui.fragments.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.ui.helpers.ShowToast
import androidx.compose.runtime.getValue

@Composable
fun BottomBar(navController: NavHostController) {
    val context = LocalContext.current

    // observe the backstack, change selected state based on current entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar {
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.Home, contentDescription = "home")
            },
            label = {
                Text(stringResource(R.string.home))
            },
            selected = (currentRoute == "home"),
            onClick = {
                navController.navigate("home")
            }
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.List, contentDescription = "magazines")
            },
            label = {
                Text(stringResource(R.string.magazines))
            },
            selected = (currentRoute == "thread"),
            onClick = {
                navController.navigate("thread")
            }
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.Create, contentDescription = "blogs")
            },
            label = {
                Text(stringResource(R.string.blogs))
            },
            selected = false,
            onClick = {
                ShowToast(context, "Hi!")
            }
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.Settings, contentDescription = "settings")
            },
            label = {
                Text(stringResource(R.string.settings))
            },
            selected = false,
            onClick = {
                ShowToast(context, "Hi!")
            }
        )
    }
}