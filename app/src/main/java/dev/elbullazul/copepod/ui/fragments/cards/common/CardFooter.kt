package dev.elbullazul.copepod.ui.fragments.cards.common

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
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.api.common.actions.Boosts
import dev.elbullazul.copepod.api.common.actions.DOWNVOTED
import dev.elbullazul.copepod.api.common.actions.Favorites
import dev.elbullazul.copepod.api.common.actions.NOT_VOTED
import dev.elbullazul.copepod.api.common.actions.UPVOTED
import dev.elbullazul.copepod.api.common.actions.Votes
import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun CommentActionButton(icon: ImageVector, text: String, description: String, pressed: Boolean, onClick: () -> Unit) {
    TextButton(contentPadding = PaddingValues(0.dp), onClick = onClick) {
        val color: Color

        if (pressed) {
            color = MaterialTheme.colorScheme.primary
        }
        else {
            color = MaterialTheme.colorScheme.secondary
        }

        Icon(
            imageVector = icon,
            contentDescription = description,
            modifier = Modifier.padding(0.dp),
            tint = color
        )
        Text(text = text, color = color)
    }
}

@Composable
fun CardFooter(post: Post) {
    val context = LocalContext.current

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background.copy(alpha = .5f),
        modifier = Modifier.height(40.dp)
    ) {
        Spacer(Modifier.weight(1f))

        if (post is Votes) {
            // TODO: fix pressed state check
            CommentActionButton(
                icon = Icons.Outlined.KeyboardArrowUp,
                text = post.upvotes.toString(),
                description = stringResource(R.string.upvote),
                pressed = (post.vote == UPVOTED),
                onClick = {
                    ShowToast(context, "Upvoted")
                    post.vote = UPVOTED
                }
            )
            CommentActionButton(
                icon = Icons.Outlined.KeyboardArrowDown,
                text = post.downvotes.toString(),
                description = stringResource(R.string.downvote),
                pressed = (post.vote == DOWNVOTED),
                onClick = {
                    ShowToast(context, "Downvoted")
                    post.vote = DOWNVOTED
                }
            )
        }

        if (post is Boosts) {
            CommentActionButton(
                icon = Icons.Outlined.Refresh,
                text = post.boosts.toString(),
                description = stringResource(R.string.favorite),
                pressed = post.boosted,
                onClick = {
                    ShowToast(context, "bookmarked")
                    post.boosted = !post.boosted
                }
            )
        }

        if (post is Favorites) {
            CommentActionButton(
                icon = Icons.Outlined.Star,
                text = post.favorites.toString(),
                description = stringResource(R.string.favorite),
                pressed = false,
                onClick = {
                    ShowToast(context, "bookmarked")
                    post.favorited = !post.favorited
                }
            )
        }

        // TODO: make conditional as well
        CommentActionButton(
            icon = Icons.Outlined.Send,
            text = "",
            description = stringResource(R.string.reply),
            pressed = false,
            onClick = {
                ShowToast(context, "coming soon!")
            }
        )
    }
}