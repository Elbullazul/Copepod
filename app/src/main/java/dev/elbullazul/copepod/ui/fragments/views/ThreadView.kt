package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.ui.fragments.cards.CommentCard
import dev.elbullazul.copepod.ui.fragments.cards.ThreadCard
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun ThreadView(thread: dev.elbullazul.copepod.api.kbin.models.Thread) {
    val context = LocalContext.current

    LazyColumn {
        // TODO: show thread content first, then comments
        item {
            ThreadCard(thread, onClick = {
                ShowToast(context, "opening thread ${thread.title}")
            })
            Divider(modifier = Modifier.padding(0.dp, 5.dp))
        }

        for (comment in thread.replies) {
            item {
                CommentCard(comment as Comment)

                if (comment != thread.replies.last()) {
                    Divider(modifier = Modifier.padding(0.dp, 5.dp))
                }
            }
        }
    }
}