package dev.elbullazul.copepod.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.ui.theme.CopepodTheme
import dev.elbullazul.copepod.ui.components.ThreadCard

class MainActivity : UserProfileActivity() {
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CopepodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(modifier = Modifier.padding(15.dp)) {
                        for (thread in TEST_THREAD_DATA) {
                            item {
                                ThreadCard(
                                    creator = thread.creator,
                                    title = thread.title,
                                    content = thread.content,
                                    upvotes = thread.upvotes,
                                    downvotes = thread.downvotes,
                                    replies = thread.replies,
                                    created = thread.created,
                                    permalink = thread.permalink
                                )
                                // don't add divider after last item
                                if (thread != TEST_THREAD_DATA.last()) {
                                    Divider(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThreadCardPreview() {
    CopepodTheme {
        LazyColumn(modifier = Modifier.padding(15.dp)) {
            for (thread in TEST_THREAD_DATA) {
                item {
                    ThreadCard(
                        creator = thread.creator,
                        title = thread.title,
                        content = thread.content,
                        upvotes = thread.upvotes,
                        downvotes = thread.downvotes,
                        replies = thread.replies,
                        created = thread.created,
                        permalink = thread.permalink
                    )
                    // don't add divider after last item
                    if (thread != TEST_THREAD_DATA.last()) {
                        Divider(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp))
                    }
                }
            }
        }
    }
    */
}