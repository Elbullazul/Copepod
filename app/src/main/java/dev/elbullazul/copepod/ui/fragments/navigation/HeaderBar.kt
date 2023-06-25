package dev.elbullazul.copepod.ui.fragments.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.R

@Composable
fun HeaderBar() {
    TopAppBar(
        title = {
            Text(stringResource(R.string.app_name))
        },
        navigationIcon = {
            //Icon(Icons.Outlined.List, contentDescription = "navigation drawer")
            Icon(Icons.Filled.ArrowBack, "backIcon", modifier = Modifier.padding(horizontal = 3.dp))
        }
    )
}