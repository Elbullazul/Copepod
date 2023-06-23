package dev.elbullazul.copepod.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.models.User

// TODO: could be reused for magazine/community header

@Composable
fun UserProfileHeader(user: User) {
    Column(modifier = Modifier.padding(15.dp)) {
        // TODO: user header composable?
        Row {
            Icon(Icons.Outlined.Person, contentDescription = "user avatar")
            Text(text = user.userName)
        }
        Text("<user description goes here>", modifier = Modifier.padding(vertical = 10.dp))
    }
}