package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.ui.fragments.cards.ThreadCard
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
// TODO: find a way to dynamically loads posts for following views
// magazine thread view, homepage thread view, etc.
// maybe different loaders but a main rendering function?
// ex. MagListView(magId) { val threads = get_mag_threads(magId); ThreadListView(threads, etc.)
// TODO: implement event parameters
fun ThreadListView(
    groupId: String? = null,
    onThreadClick: (threadId: String) -> Unit,
    onUserClick: (userId: String) -> Unit
) {
    val context = LocalContext.current
    val threads = TEST_THREADS

    if (groupId != null) {
        // load threads from group
        // groupId instead of thread (lemmy) or magazine (kbin)
    }

    // TODO: implement retrieval of data

    LazyColumn {
        for (thread in threads) {
            item {
                ThreadCard(post = thread,
                    onClick = {
                        onThreadClick(thread.id)
                    },
                    onUserClick = {
                        onUserClick(thread.creator.name)
                    },
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