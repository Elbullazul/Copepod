package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.backends.kbin.KbinWrapper
import dev.elbullazul.copepod.backends.kbin.models.KComment
import dev.elbullazul.copepod.ui.fragments.cards.PostCard

@Composable
fun PostView(
    threadId: String? = "0",
    onUserClick: (Int) -> Unit = {}
) {
    // TODO: fail more gracefully
    if (threadId == null) {
        Text("Something went wrong, try again")
        return
    }

    val wrapper = KbinWrapper()
    val thread = wrapper.Post(threadId)

    LazyColumn {
        // TODO: show thread content first, then comments
        item {
            PostCard(thread)
            Divider(modifier = Modifier.padding(0.dp, 5.dp))
        }

        for (comment in thread.replies) {
            item {
                PostCard(
                    comment as KComment,
                    onUserClick = onUserClick
                )

                if (comment != thread.replies.last()) {
                    Divider(modifier = Modifier.padding(0.dp, 5.dp))
                }
            }
        }
    }
}