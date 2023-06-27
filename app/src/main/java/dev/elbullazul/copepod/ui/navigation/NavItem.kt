package dev.elbullazul.copepod.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

interface NavItem {
    val label: Int
    val icon: ImageVector
    val route: String
//    val view: @Composable () -> Unit
}