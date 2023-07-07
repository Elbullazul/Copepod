package dev.elbullazul.copepod.backends.kbin.data

import dev.elbullazul.copepod.backends.kbin.models.KBlog
import dev.elbullazul.copepod.backends.kbin.models.KComment
import dev.elbullazul.copepod.backends.kbin.models.KMagazine
import dev.elbullazul.copepod.backends.kbin.models.KUser
import dev.elbullazul.copepod.backends.kbin.models.KThread
import java.util.Date

var TEST_K_USERS = listOf(
    KUser("/api/users/elbullazul", "elbullazul"),
    KUser("u.fail/u/stux", "stux 😸"),
    KUser("sh.itjust.works/u/thedude", "TheDude"),
    KUser("lemmy.world/u/ruud", "ruud")
)

var TEST_K_COMMENTS = listOf(
    KComment(
        creator = TEST_K_USERS[0],
        created = Date(),
        body = "This is a test comment to see how Android will render this",
        url = "",
        replies = emptyList(),
        upvotes = 15,
        downvotes = 3,
        boosts = 5
    ),
    KComment(
        creator = TEST_K_USERS[1],
        created = Date(),
        body = "😺",
        url = "",
        replies = emptyList(),
        upvotes = 150,
        downvotes = 3,
        boosts = 17
    ),
    KComment(
        creator = TEST_K_USERS[2],
        created = Date(),
        body = "Thanks, you too!",
        url = "",
        replies = emptyList(),
        upvotes = 4,
        downvotes = 0,
        boosts = 0
    ),
    KComment(
        creator = TEST_K_USERS[3],
        created = Date(),
        body = "calckey.world is now back online",
        url = "",
        replies = emptyList(),
        upvotes = 14,
        downvotes = 0,
        boosts = 2
    )
)

var TEST_K_MAGAZINES = listOf(
    KMagazine("m-linux", "Linux", description = "A community for all things Linux"),
    KMagazine("m-cs", "Counter-strike", description = "A community for Valve's CS videogame"),
    KMagazine("lemmy.world-c-selfhosted", "Self-hosted", description = "A group to discuss self-hosting")
)

var TEST_K_THREADS = listOf(
    KThread(
        id = "lemmy.ml-hi",
        creator = TEST_K_USERS[0],
        created = Date(),
        title = "Interesting title",
        body = "I’m still playing around getting my bearings here, trying to explore this still-growing federation. I’ve tried browsing by “New” on both mobile and desktop a couple of times, but on desktop it’s almost unsuable. Any time there’s a new post, the INSTANT it goes up my feed updates, and scrolls down. Sometimes it’s one post, sometimes a dozen.\n" +
                "\n" +
                "To me (opinion here), sorting by “new” should sort of be a timestampped thing: I want “new as of right now but nothing more”. If I refresh, sure update me to the latest. But a list that’s live updating as things happen? That’s… not useful to me.\n" +
                "\n" +
                "Am I missing something, or does anyone else feel similarly?",
        description = "I’m still playing around getting my bearings here, trying to explore this still-growing federation. I’ve tried browsing by “New” on both mobile...",
        group = TEST_K_MAGAZINES[0],
        upvotes = 10,
        downvotes = 5,
        boosts = 0,
        url = "https://kbin.social/",
        replies = listOf(
            TEST_K_COMMENTS[0],
            TEST_K_COMMENTS[1]
        )
    ),
    KThread(
        id = "u.fail-cats",
        creator = TEST_K_USERS[1],
        created = Date(),
        title = "Reddit? u.fail!",
        body = "![img](https://imgur.com/logo.png)",
        description = "![img](https://imgur.com/logo.png)",
        group = TEST_K_MAGAZINES[0],
        upvotes = 100,
        downvotes = 0,
        boosts = 0,
        url = "https://u.fail/",
        replies = listOf(
            TEST_K_COMMENTS[0]
        )
    ),
    KThread(
        id = "sh.itjust.works-statement",
        creator = TEST_K_USERS[2],
        created = Date(),
        title = "sh.itjust.works is now live!",
        body = "**Bold statements only on this line!**",
        description = "**Bold statements only on this line!**",
        group = TEST_K_MAGAZINES[1],
        upvotes = 75,
        downvotes = 0,
        boosts = 0,
        url = "https://sh.itjust.works/",
        replies = listOf(
            TEST_K_COMMENTS[0],
            TEST_K_COMMENTS[1],
            TEST_K_COMMENTS[2],
            TEST_K_COMMENTS[3],
        )
    ),
    KThread(
        id = "lemmy.world-back-up",
        creator = TEST_K_USERS[3],
        created = Date(),
        title = "Welcome to Lemmy.world!",
        body = "# Glad to see so many new people joining us!",
        description = "# Glad to see so many new people joining us!",
        group = TEST_K_MAGAZINES[2],
        upvotes = 50,
        downvotes = 1,
        boosts = 0,
        url = "https://lemmy.world/",
        replies = emptyList()
    )
)

var TEST_K_BLOGS = listOf(
    KBlog(
        creator = TEST_K_USERS[0],
    )
)