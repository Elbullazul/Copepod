package dev.elbullazul.copepod.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.ui.components.CommentCard
import dev.elbullazul.copepod.ui.components.ThreadCard
import dev.elbullazul.copepod.ui.helpers.ShowToast
import dev.elbullazul.copepod.ui.theme.CopepodTheme

open class ThreadActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CopepodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ThreadView(TEST_THREADS[2])
                    }
                }
            }
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun ThreadPreview() {
    CopepodTheme {
        ThreadView(TEST_THREADS[2])
    }
}