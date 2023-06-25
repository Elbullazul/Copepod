package dev.elbullazul.copepod.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.ui.fragments.views.MagazineListView
import dev.elbullazul.copepod.ui.fragments.views.SettingsView
import dev.elbullazul.copepod.ui.fragments.views.ThreadListView
import dev.elbullazul.copepod.ui.fragments.views.UserProfileView

object Overview: NavItem {
    override val label = R.string.home
    override val icon = Icons.Outlined.Home
    override val route = "threads"
    override val view: @Composable () -> Unit = { ThreadListView(threads = TEST_THREADS) }
}

// TODO: implement view
object Magazines: NavItem {
    override val label = R.string.magazines
    override val icon = Icons.Outlined.List
    override val route = "magazines"
    override val view: @Composable () -> Unit = { MagazineListView() }
}

// TODO: implement view
object Blogs: NavItem {
    override val label = R.string.blogs
    override val icon = Icons.Outlined.Edit
    override val route = "blogs"
    override val view: @Composable () -> Unit = { UserProfileView(
        comments = TEST_COMMENTS,
        threads = TEST_THREADS,
        blogs = emptyList()
    ) }
}

// TODO: implement view
object Settings: NavItem {
    override val label = R.string.settings
    override val icon = Icons.Outlined.Settings
    override val route = "settings"
    override val view: @Composable () -> Unit = { SettingsView() }
}

object Screens {
    val NavItems = listOf<NavItem>(
        Overview,
        Magazines,
        Blogs,
        Settings
    )
}