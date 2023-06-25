package dev.elbullazul.copepod.ui.fragments.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.render.MarkdownBody
import dev.elbullazul.copepod.ui.fragments.cards.common.CardFooter
import dev.elbullazul.copepod.ui.fragments.cards.common.CardHeader
import dev.elbullazul.copepod.ui.theme.CopepodTheme

// TODO: support comment tree (connect to parent comment node)
@Composable
fun CommentCard(comment: Comment) {

    /* TODO: actions */
    // parse content and display media and styles correctly
    // clickable
    // collapse
    // text select

    // TODO: apply horizontal padding to everything minus the Footer
    Column {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            CardHeader(creator = comment.creator.name, created = comment.created)
            MarkdownBody(comment.body)
        }
        CardFooter(upvotes = comment.upvotes, downvotes = comment.downvotes)
    }
}

@Preview(showBackground = true)
@Composable
fun CommentCardPreview() {
    CopepodTheme {
        Column() {
            CommentCard(TEST_COMMENTS[0])
        }
    }
}