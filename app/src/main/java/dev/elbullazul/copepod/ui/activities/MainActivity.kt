package dev.elbullazul.copepod.ui.activities

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