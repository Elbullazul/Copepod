package dev.elbullazul.copepod.ui.fragments.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun CommentActionButton(icon: ImageVector, text: String, description: String, onClick: () -> Unit) {
    TextButton(contentPadding = PaddingValues(0.dp), onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            modifier = Modifier.padding(0.dp),
            tint = MaterialTheme.colorScheme.secondary
        )
        Text(text = text, color = MaterialTheme.colorScheme.secondary)
    }
}

// TODO: toggle on load if already marked as upvoted
@Composable
fun CardFooter(upvotes: Int, downvotes: Int) {
    val context = LocalContext.current

    // TODO: shorten vote amount if over 1000 (ex. 1587 votes -> 1.5k?)

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background.copy(alpha = .5f),
        modifier = Modifier.height(40.dp)) {

        Spacer(Modifier.weight(1f))

        CommentActionButton(Icons.Outlined.KeyboardArrowUp, upvotes.toString(), stringResource(R.string.upvote), onClick = {
            ShowToast(context, "Upvoted")
        })

        CommentActionButton(Icons.Outlined.KeyboardArrowDown, downvotes.toString(), stringResource(R.string.downvote), onClick = {
            ShowToast(context, "Downvoted")
        })

        CommentActionButton(Icons.Outlined.Star, "", stringResource(R.string.favorite), onClick = {
            ShowToast(context, "bookmarked")
        })

        CommentActionButton(Icons.Outlined.Send, "", stringResource(R.string.reply), onClick = {
            ShowToast(context, "coming soon!")
        })
    }
}