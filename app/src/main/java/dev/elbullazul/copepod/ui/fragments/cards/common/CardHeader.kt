package dev.elbullazul.copepod.ui.fragments.cards.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun CardHeader(creator: String, created: Date) {
    Row(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)) {
        Text(text = "@$creator", color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.weight(1f))

        Text(
            text = "  ${SimpleDateFormat("MMM dd, yyyy (hh:mm)").format(created)}",
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}