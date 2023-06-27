package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.ui.fragments.cards.ThreadCard
import dev.elbullazul.copepod.ui.helpers.ShowToast

@Composable
fun ThreadListView(magId: String? = null) {
    val context = LocalContext.current
    val threads = TEST_THREADS

    // TODO: implement retrieval of data

    LazyColumn {
        for (thread in threads) {
            item {
                ThreadCard(post = thread, onClick = {
                    ShowToast(context, "opening thread ${thread.title}")
                })

                if (thread != threads.last()) {
                    Divider(modifier = Modifier.padding(0.dp, 5.dp))
                }
            }
        }
    }

// events
//    onThreadClick()
//    onUserClick()
//    onMagazineClick
//    onUpvoteClick
//    onDownvoteClick
//    onBoostClick()
//    onFavoriteClick
}