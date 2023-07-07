package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_THREADS
import dev.elbullazul.copepod.ui.fragments.cards.PostCard

@Composable
fun PostListView(
    groupId: String? = null,
    onThreadClick: (threadId: String) -> Unit = {},
    onUserClick: (userId: String) -> Unit = {},
    onGroupClick: (groupId: String) -> Unit = {}
) {
    val threads = TEST_K_THREADS

    if (groupId != null) {
        // TODO: fetch data from group
    }

    LazyColumn {
        for (thread in threads) {
            item {
                PostCard(
                    post = thread,
                    preview = true,
                    onClick = {
                        onThreadClick(thread.id)
                    },
                    onUserClick = {
                        onUserClick(thread.creator.name)
                    },
                    onGroupClick = {
                        onGroupClick(thread.group.id)
                    }
                )

                if (thread != threads.last()) {
                    Divider(modifier = Modifier.padding(0.dp, 5.dp))
                }
            }
        }
    }

// events
//    onThreadClick
//    onUserClick
//    onMagazineClick
//    onUpvoteClick
//    onDownvoteClick
//    onBoostClick
//    onFavoriteClick
}