package dev.elbullazul.copepod.ui.fragments.cards.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elbullazul.copepod.backends.common.models.Post
import java.text.SimpleDateFormat

@Composable
fun CardHeader(post: Post, onUserClick: (Int) -> Unit) {
    val context = LocalContext.current

    Row(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)) {
//        Text(
//            text = "@$creator",
//            color = MaterialTheme.colorScheme.primary
//        )

        // TODO: displayName if available
        ClickableText(
            text = AnnotatedString(post.creator.name),
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp
            ),
            onClick = onUserClick
        )
        Spacer(Modifier.weight(1f))

        Text(
            text = "  ${SimpleDateFormat("MMM dd, yyyy (hh:mm)").format(post.created)}",
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}