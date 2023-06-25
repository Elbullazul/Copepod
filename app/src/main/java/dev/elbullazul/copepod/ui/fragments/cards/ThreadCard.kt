package dev.elbullazul.copepod.ui.fragments.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.render.MarkdownBody
import dev.elbullazul.copepod.ui.fragments.common.CardFooter
import dev.elbullazul.copepod.ui.fragments.common.CardHeader
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.ui.theme.CopepodTheme

@Composable
fun ThreadCard(thread: Thread, onClick: () -> Unit) {
    // TODO: add community/magazine (requires rework to Thread object)
    // TODO: implement onClick action
    Column {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Text(thread.magazine.name, color = MaterialTheme.colorScheme.secondary)
            Text(
                text = thread.title,
                fontSize = 22.sp,
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
            )
            Spacer(modifier = Modifier.padding(vertical = 1.dp))
            CardHeader(creator = thread.creator.name, created = thread.created)
            MarkdownBody(source = thread.body)
        }

        Row {
            Text(
                "${thread.replies.count()} ${stringResource(R.string.replies)}",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 15.dp)
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