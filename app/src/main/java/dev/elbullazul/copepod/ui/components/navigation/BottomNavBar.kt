package dev.elbullazul.copepod.ui.components.navigation

import android.content.Context
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun BottomNavBar(context: Context) {
   // val selected = remember { mutableStateOf(BottomIcons.MENU) }

    BottomAppBar(
        //containerColor = MaterialTheme.colorScheme.background.copy(alpha = .5f),
        //modifier = Modifier.height(40.dp)) {
    ){
        Button(onClick = { ShowToast(context, "Hi!") }) {
            Text("Test button")
        }
    }
}