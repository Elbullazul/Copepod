package dev.elbullazul.copepod.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.elbullazul.copepod.R

object HomeScreen: NavItem {
    override val label = R.string.home
    override val icon = Icons.Outlined.Home
    override val route = "threads"
}

// TODO: rename
object MagazineListScreen: NavItem {
    override val label = R.string.magazines
    override val icon = Icons.Outlined.List
    override val route = "magazines"
}

object SettingsScreen: NavItem {
    override val label = R.string.settings
    override val icon = Icons.Outlined.Settings
    override val route = "settings"
}

// content screens
object ThreadScreen: NavItem {
    override val label = R.string.home
    override val icon = Icons.Outlined.Home
    override val route = "thread"

    const val threadIdArg: String = "threadId"

    val routeWithArgs = "${route}/{${threadIdArg}}"
    val arguments = listOf(
        navArgument(threadIdArg) { type = NavType.StringType }
    )
}

object UserScreen: NavItem {
    override val label = R.string.home
    override val icon = Icons.Outlined.Home
    override val route = "user"

    const val userNameArg: String = "userName"

    val routeWithArgs = "${route}/{${userNameArg}}"
    val arguments = listOf(
        navArgument(userNameArg) { type = NavType.StringType }
    )
}