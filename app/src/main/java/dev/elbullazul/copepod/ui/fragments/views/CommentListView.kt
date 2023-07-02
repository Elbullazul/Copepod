package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.ui.fragments.cards.CommentCard
import dev.elbullazul.copepod.api.kbin.models.Comment

@Composable
fun CommentListView() {
    // test data
    val comments = TEST_COMMENTS

    LazyColumn {
        // TODO: make a CommentList component?
        for (comment in comments) {
            item {
                CommentCard(comment, onUserClick = {})

                // divider only if not last
                if (comment != comments.last()) {
                    Divider(modifier = Modifier.padding(0.dp, 5.dp))
                }
            }
        }
    }
}

