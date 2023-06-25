package dev.elbullazul.copepod.ui.fragments.navigation

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun BottomBar() {
    // val selected = remember { mutableStateOf(BottomIcons.MENU) }
    val context = LocalContext.current

    BottomAppBar(
        //containerColor = MaterialTheme.colorScheme.background.copy(alpha = .5f),
        //modifier = Modifier.height(40.dp)) {
    ) {
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.Home, contentDescription = "home")
            },
            label = {
                Text(stringResource(R.string.home))
            },
            selected = true,
            onClick = {
                ShowToast(context, "Hi!")
            }
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.List, contentDescription = "magazines")
            },
            label = {
                Text(stringResource(R.string.magazines))
            },
            selected = false,
            onClick = {
                ShowToast(context, "Hi!")
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