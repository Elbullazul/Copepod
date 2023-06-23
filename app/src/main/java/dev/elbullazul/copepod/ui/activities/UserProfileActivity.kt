package dev.elbullazul.copepod.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.ui.components.CommentCard
import dev.elbullazul.copepod.ui.theme.CopepodTheme

// fix "Type '' has no getValue for mutableStateOf"
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import dev.elbullazul.copepod.api.common.Post
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.models.User
import dev.elbullazul.copepod.ui.components.ThreadCard
import dev.elbullazul.copepod.ui.components.UserProfileHeader
import dev.elbullazul.copepod.ui.components.navigation.BottomNavBar
import dev.elbullazul.copepod.ui.components.navigation.HeaderAppBar
import dev.elbullazul.copepod.ui.helpers.ShowToast

open class UserProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get data
        var userComments = TEST_COMMENTS
        var userThreads = TEST_THREADS
        var userBlogs = emptyList<Post>()
        var userReplies = emptyList<Post>()

        setContent {
            CopepodTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO: app header
                    val context = LocalContext.current

                    Scaffold(
                        topBar = { HeaderAppBar() },
                        bottomBar = { BottomNavBar(context) }
                    ) { contentPadding ->
                        Column(modifier = Modifier.padding(contentPadding)) {
                            UserProfileView(userComments, userThreads, userBlogs, userReplies)
                            Spacer(Modifier.weight(1f))
                        }
                    }


                    // TODO: navbar
                }
            }
        }
    }
}

@Composable
fun UserProfileView(comments: List<Comment>, threads: List<Thread>, blogs: List<Post>, replies: List<Post>) {
    val tabList = listOf("Comments", "Threads", "Blogs", "Replies")
    var tabIndex by remember { mutableStateOf(0) }
    val context = LocalContext.current
    val user = User("elbullazul", "", "Elbullazul")

    Column {//(modifier = Modifier.fillMaxSize()) {
        // user header
        UserProfileHeader(user)

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
            0 -> LazyColumn {
                // TODO: make a CommentList component?
                for (comment in comments) {
                    item {
                        CommentCard(comment)

                        // divider only if not last
                        if (comment != comments.last()) {
                            Divider(modifier = Modifier.padding(0.dp, 5.dp))
                        }
                    }
                }
            }
            // TODO: composable Timeline
            1 -> LazyColumn {
                // TODO: make a ThreadView component?

                for (thread in threads) {
                    item {
                        ThreadCard(thread = thread, onClick = {
                            ShowToast(context, "opening thread ${thread.title}")
                        })

                        if (thread != threads.last()) {
                            Divider(modifier = Modifier.padding(0.dp, 5.dp))
                        }
                    }
                }
            }
            // TODO: composable Blog
            2 -> Text("Blogs")
            3 -> Text("Replies")
        }
    }
}

@Composable
@Preview
fun UserProfilePreview() {
    CopepodTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UserProfileView(TEST_COMMENTS, TEST_THREADS, emptyList(), emptyList())
        }
    }
}