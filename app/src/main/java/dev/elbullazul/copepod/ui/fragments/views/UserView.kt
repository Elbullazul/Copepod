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
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_USERS
import dev.elbullazul.copepod.ui.fragments.cards.ActorCard

@Composable
fun UserView(
    userName: String? = null,
    onThreadClick: (String) -> Unit = {},
    onCommentClick: (String) -> Unit = {},
    onBlogClick: (String) -> Unit = {}
) {
    val tabList = listOf(
        stringResource(R.string.comments),
        stringResource(R.string.threads),
        stringResource(R.string.blogs)
    )
    var tabIndex by remember { mutableStateOf(0) }

    // test data
    val user = TEST_K_USERS[0]

    Column {
        // user header
        ActorCard(user)

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
            0 -> PostListView(
                // TODO: only replies
                onThreadClick = onThreadClick,
            )
            1 -> PostListView(
                // TODO: only posts?
                onThreadClick = onThreadClick,
            )
//            2 -> BlogListView(
//                onPostClick
//                onUserClick
//                onHashtagClick (reuse group view?)
//            )
        }
    }
}