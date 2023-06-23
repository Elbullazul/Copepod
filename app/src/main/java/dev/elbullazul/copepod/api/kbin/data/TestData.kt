package dev.elbullazul.copepod.api.kbin.data

import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.api.kbin.models.User
import dev.elbullazul.copepod.api.kbin.models.Thread
import java.util.Date

var TEST_USERS = listOf<User>(
    User("elbullazul", "", "Elbullazul"),
    User("stux", "", "stux"),
    User("thedude", "", "TheDude"),
    User("ruud", "", "Ruud")
)

var TEST_COMMENTS = listOf<Comment>(
    Comment(
        creator = TEST_USERS[0],
        created = Date(),
        body = "This is a test comment to see how Android will render this",
        url = "",
        originUrl = "",
        replies = emptyList(),
        //parent = Thread(),
        upvotes = 15,
        downvotes = 3,
        boosts = 5
    ),
    Comment(
        creator = TEST_USERS[1],
        created = Date(),
        body = "😺",
        url = "",
        originUrl = "",
        replies = emptyList(),
//        parent = Thread(),
        upvotes = 150,
        downvotes = 3,
        boosts = 17
    ),
    Comment(
        creator = TEST_USERS[2],
        created = Date(),
        body = "Thanks, you too!",
        url = "",
        originUrl = "",
        replies = emptyList(),
//        parent = Thread(),
        upvotes = 4,
        downvotes = 0,
        boosts = 0
    ),
    Comment(
        creator = TEST_USERS[3],
        created = Date(),
        body = "calckey.world is now back online",
        url = "",
        originUrl = "",
        replies = emptyList(),
//        parent = Thread(),
        upvotes = 14,
        downvotes = 0,
        boosts = 2
    )
)

var TEST_THREADS = listOf<Thread>(
    Thread(
        creator = TEST_USERS[0],
        created = Date(),
        title = "Interesting title",
        body = "I’m still playing around getting my bearings here, trying to explore this still-growing federation. I’ve tried browsing by “New” on both mobile and desktop a couple of times, but on desktop it’s almost unsuable. Any time there’s a new post, the INSTANT it goes up my feed updates, and scrolls down. Sometimes it’s one post, sometimes a dozen.\n" +
                "\n" +
                "To me (opinion here), sorting by “new” should sort of be a timestampped thing: I want “new as of right now but nothing more”. If I refresh, sure update me to the latest. But a list that’s live updating as things happen? That’s… not useful to me.\n" +
                "\n" +
                "Am I missing something, or does anyone else feel similarly?",
        upvotes = 10,
        downvotes = 5,
        boosts = 0,
        url = "https://kbin.social/",
        originUrl = "https://kbin.social/",
        replies = listOf<Comment>(
            TEST_COMMENTS[0],
            TEST_COMMENTS[1]
        )
    ),
    Thread(
        creator = TEST_USERS[1],
        created = Date(),
        title = "Reddit? u.fail!",
        body = "![img](https://imgur.com/logo.png)",
        upvotes = 100,
        downvotes = 0,
        boosts = 0,
        url = "https://u.fail/",
        originUrl = "",
        replies = listOf<Comment>(
            TEST_COMMENTS[0]
        )
    ),
    Thread(
        creator = TEST_USERS[2],
        created = Date(),
        title = "sh.itjust.works is now live!",
        body = "**Bold statements only on this line!**",
        upvotes = 75,
        downvotes = 0,
        boosts = 0,
        url = "https://sh.itjust.works/",
        originUrl = "",
        replies = listOf<Comment>(
            TEST_COMMENTS[0],
            TEST_COMMENTS[1],
            TEST_COMMENTS[2],
            TEST_COMMENTS[3],
        )
    ),
    Thread(
        creator = TEST_USERS[3],
        created = Date(),
        title = "Welcome to Lemmy.world!",
        body = "# Glad to see so many new people joining us!",
        upvotes = 50,
        downvotes = 1,
        boosts = 0,
        url = "https://lemmy.world/",
        originUrl = "",
        replies = emptyList()
    )
)