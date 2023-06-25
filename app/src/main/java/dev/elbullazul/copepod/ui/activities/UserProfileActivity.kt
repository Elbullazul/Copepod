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

// fix "Type '' has no getValue for mutableStateOf"
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.elbullazul.copepod.ui.fragments.cards.CommentCard
import dev.elbullazul.copepod.ui.theme.CopepodTheme
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.api.kbin.models.Thread
import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.api.kbin.data.TEST_COMMENTS
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.data.TEST_USERS
import dev.elbullazul.copepod.ui.fragments.cards.ThreadCard
import dev.elbullazul.copepod.ui.fragments.cards.UserProfileCard
import dev.elbullazul.copepod.ui.fragments.navigation.BottomBar
import dev.elbullazul.copepod.ui.fragments.navigation.HeaderBar
import dev.elbullazul.copepod.ui.fragments.views.CommentListView
import dev.elbullazul.copepod.ui.fragments.views.ThreadListView
import dev.elbullazul.copepod.ui.fragments.views.UserProfileView
import dev.elbullazul.copepod.ui.helpers.ShowToast

open class UserProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get data
        val userComments = TEST_COMMENTS
        val userThreads = TEST_THREADS
        val userBlogs = emptyList<Post>()

        setContent {
            CopepodTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { HeaderBar() },
                        bottomBar = { BottomBar() }
                    ) { contentPadding ->
                        Column(modifier = Modifier.padding(contentPadding)) {
                            UserProfileView(userComments, userThreads, userBlogs)
                            Spacer(Modifier.weight(1f))
                        }
                    }
                }
            }
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
            UserProfileView(TEST_COMMENTS, TEST_THREADS, emptyList())
        }
    }
}