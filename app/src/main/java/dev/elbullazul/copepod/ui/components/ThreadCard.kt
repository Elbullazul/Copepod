package dev.elbullazul.copepod.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.render.MarkdownBody
import dev.elbullazul.copepod.ui.components.common.CardFooter
import dev.elbullazul.copepod.ui.components.common.CardHeader
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.ui.theme.CopepodTheme

// mostly the same that comment
@Composable
fun ThreadCard(thread: Thread, onClick: () -> Unit) {
    // TODO: add community/magazine (requires rework to Thread object)
    // TODO: implement onClick action
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        // add title to header
        Text(
            text = thread.title,
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
        )
        CardHeader(creator = thread.creator.userName, created = thread.created)

        MarkdownBody(source = thread.body)

        // add reply count to footer
        Row {
            Text(
                "${thread.replies.count()} replies",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            CardFooter(upvotes = thread.upvotes, downvotes = thread.downvotes)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThreadCardPreview() {
    CopepodTheme {
        Column {
            ThreadCard(TEST_THREADS[1], onClick = {

            })
        }
    }
}