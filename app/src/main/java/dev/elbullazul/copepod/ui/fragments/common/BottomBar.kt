package dev.elbullazul.copepod.ui.fragments.common

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import dev.elbullazul.copepod.ui.navigation.BottomNavigation

@Composable
fun BottomBar(navController: NavHostController) {
    val context = LocalContext.current

    // observe the backstack, change selected state based on current entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar {
        for (navItem in BottomNavigation.NavItems) {
            NavigationBarItem(
                icon = { Icon(navItem.icon, contentDescription = navItem.route) },
                label = { Text(stringResource(navItem.label)) },
                selected = (currentRoute == navItem.route),
                onClick = { navController.navigate(navItem.route) }
            )
        }
    }
}