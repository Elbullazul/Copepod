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
import dev.elbullazul.copepod.api.common.interfaces.Boosts
import dev.elbullazul.copepod.api.common.interfaces.Favorites
import dev.elbullazul.copepod.api.common.interfaces.VoteStatus
import dev.elbullazul.copepod.api.common.interfaces.Votes
import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun ActionButton(icon: ImageVector, text: String, description: String, pressed: Boolean, onClick: () -> Unit) {
    TextButton(contentPadding = PaddingValues(0.dp), onClick = onClick) {

        val color: Color = if (pressed) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.secondary
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
            ActionButton(
                icon = Icons.Outlined.KeyboardArrowUp,
                text = post.upvotes.toString(),
                description = stringResource(R.string.upvote),
                pressed = (post.vote == VoteStatus.UPVOTED),
                onClick = {
                    ShowToast(context, "upvoting ${post.id}")
                    post.vote = VoteStatus.UPVOTED
                }
            )
            ActionButton(
                icon = Icons.Outlined.KeyboardArrowDown,
                text = post.downvotes.toString(),
                description = stringResource(R.string.downvote),
                pressed = (post.vote == VoteStatus.DOWNVOTED),
                onClick = {
                    ShowToast(context, "downvoting ${post.id}")
                    post.vote = VoteStatus.DOWNVOTED
                }
            )
        }

        if (post is Boosts) {
            ActionButton(
                icon = Icons.Outlined.Refresh,
                text = post.boosts.toString(),
                description = stringResource(R.string.favorite),
                pressed = post.boosted,
                onClick = {
                    ShowToast(context, "boosted ${post.id}")
                    post.boosted = !post.boosted
                }
            )
        }

        if (post is Favorites) {
            ActionButton(
                icon = Icons.Outlined.Star,
                text = post.favorites.toString(),
                description = stringResource(R.string.favorite),
                pressed = false,
                onClick = {
                    ShowToast(context, "favorited ${post.id}")
                    post.favorited = !post.favorited
                }
            )
        }

        // TODO: make conditional as well
        ActionButton(
            icon = Icons.Outlined.Send,
            text = "",
            description = stringResource(R.string.reply),
            pressed = false,
            onClick = {
                ShowToast(context, "replying to post ${post.id}")
            }
        )
    }
}