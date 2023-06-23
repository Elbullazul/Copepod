package dev.elbullazul.copepod.ui.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeaderAppBar() {
    TopAppBar(
        title = {
            Text("Copepod")
        },
        navigationIcon = {
            //Icon(Icons.Outlined.List, contentDescription = "navigation drawer")
            Icon(Icons.Filled.ArrowBack, "backIcon", modifier = Modifier.padding(horizontal = 3.dp))
        }
    )
}