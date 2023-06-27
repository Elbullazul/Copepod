package dev.elbullazul.copepod.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.ui.fragments.views.BlogListView
import dev.elbullazul.copepod.ui.fragments.views.MagazineListView
import dev.elbullazul.copepod.ui.fragments.views.SettingsView
import dev.elbullazul.copepod.ui.fragments.views.ThreadListView

// main screens
object Overview: NavItem {
    override val label = R.string.home
    override val icon = Icons.Outlined.Home
    override val route = "threads"
//    override val view: @Composable () -> Unit = { ThreadListView() }
}

object Magazines: NavItem {
    override val label = R.string.magazines
    override val icon = Icons.Outlined.List
    override val route = "magazines"
//    override val view: @Composable () -> Unit = { MagazineListView() }
}

object Blogs: NavItem {
    override val label = R.string.blogs
    override val icon = Icons.Outlined.Edit
    override val route = "blogs"
//    override val view: @Composable () -> Unit = { BlogListView() }
}

object Settings: NavItem {
    override val label = R.string.settings
    override val icon = Icons.Outlined.Settings
    override val route = "settings"
//    override val view: @Composable () -> Unit = { SettingsView() }
}

// content screens
// TODO: rename?
object PostView: NavItem {
    override val label = R.string.home
    override val icon = Icons.Outlined.Home
    override val route = "thread"
//    override val view: @Composable () -> Unit = { ThreadListView() }
    const val threadIdArg: String = "threadId"
    val arguments = listOf(
        navArgument(threadIdArg) { type = NavType.StringType }
    )
}


object Screens {
    val NavItems = listOf(
        Overview,
        Magazines,
        Blogs,
        Settings
    )
}