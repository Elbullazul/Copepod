package dev.elbullazul.copepod.ui.fragments.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.backends.common.features.Description
import dev.elbullazul.copepod.backends.common.features.GroupMember
import dev.elbullazul.copepod.backends.common.features.Title
import dev.elbullazul.copepod.backends.common.models.Post
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_THREADS
import dev.elbullazul.copepod.render.MarkdownBody
import dev.elbullazul.copepod.ui.fragments.cards.common.CardFooter
import dev.elbullazul.copepod.ui.fragments.cards.common.CardHeader
import dev.elbullazul.copepod.backends.kbin.models.KThread
import dev.elbullazul.copepod.ui.theme.CopepodTheme

@Composable
fun PostCard(
    post: Post,
    preview: Boolean = false,
    onClick: (Int) -> Unit = {},
    onUserClick: (Int) -> Unit = {},
    onGroupClick: (Int) -> Unit = {}
) {
    // TODO: add community/magazine (requires rework to Thread object)
    // TODO: implement onClick action
    Column {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            // show group name if post is from a group
            if (post is GroupMember) {
                ClickableText(
                    text = AnnotatedString(post.group.name),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp
                    ),
                    onClick = onGroupClick
                )
            }
            // show title if post has title
            if (post is Title) {
                ClickableText(
                    text = AnnotatedString(post.title),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.inverseSurface,
                        fontSize = 22.sp
                    ),
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp),
                    onClick = onClick
                )
//                Spacer(modifier = Modifier.padding(vertical = 1.dp))
            }
            CardHeader(post, onUserClick = onUserClick)
            MarkdownBody(
                source = if (preview && post is Description) {
                        post.description
                    } else {
                        post.body
                    },
                onClick = onClick
            )
        }

        Row {
            // only show number of replies for root posts
            if (post.root == null) {
                Text(
                    text = "${post.replies.count()} ${stringResource(R.string.replies)}",
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 15.dp)
                )
            }
            CardFooter(post)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    CopepodTheme {
        Column {
            PostCard(TEST_K_THREADS[1])
        }
    }
}