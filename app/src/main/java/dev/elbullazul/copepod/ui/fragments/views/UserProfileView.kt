package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.data.TEST_USERS
import dev.elbullazul.copepod.ui.fragments.cards.PreviewCard

@Composable
// TODO: remove null default when testing complete
fun UserProfileView(
    userName: String? = null,
    onThreadClick: (String) -> Unit,
    onCommentClick: (String) -> Unit,
    onBlogClick: (String) -> Unit
) {
    val tabList = listOf(
        stringResource(R.string.comments),
        stringResource(R.string.threads),
        stringResource(R.string.blogs)
    )
    var tabIndex by remember { mutableStateOf(0) }

    // test data
    val user = TEST_USERS[0]
    val comments = TEST_COMMENTS
    val threads = TEST_THREADS

    Column {
        // user header
        PreviewCard(user)

        // user submission tabs
        TabRow(selectedTabIndex = tabIndex) {
            tabList.forEachIndexed { index, text ->
                Tab(selected = (tabIndex == index), onClick = {
                    tabIndex = index
                }, text = {
                    Text(text = text)
                })
            }
        }
        when (tabIndex) {
            0 -> CommentListView()
            1 -> ThreadListView(
                onThreadClick = onThreadClick,
                onUserClick = {},    // do nothing since only current user posts appear
            )
            2 -> Text(
                "Blogs"
//            onBlogClick
            )
        }
    }
}