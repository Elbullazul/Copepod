package dev.elbullazul.copepod.ui.fragments.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.render.MarkdownBody
import dev.elbullazul.copepod.ui.fragments.cards.common.CardFooter
import dev.elbullazul.copepod.ui.fragments.cards.common.CardHeader
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.ui.theme.CopepodTheme

@Composable
fun ThreadCard(post: Post, onClick: (Int) -> Unit) {
    // TODO: add community/magazine (requires rework to Thread object)
    // TODO: implement onClick action
    Column {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            if (post is Thread) {
                ClickableText(
                    text = AnnotatedString(post.magazine.name),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp
                    ),
                    onClick = onClick
                )
                ClickableText(
                    text = AnnotatedString(post.title),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.inverseSurface,
                        fontSize = 22.sp
                    ),
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp),
                    onClick = onClick
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 1.dp))
            CardHeader(post)
            MarkdownBody(
                source = post.body,
                onClick = onClick
            )
        }

        Row {
            Text(
                "${post.replies.count()} ${stringResource(R.string.replies)}",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 15.dp)
            )
            CardFooter(post)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThreadCardPreview() {
    CopepodTheme {
        Column {
            ThreadCard(TEST_THREADS[1], onClick = {})
        }
    }
}