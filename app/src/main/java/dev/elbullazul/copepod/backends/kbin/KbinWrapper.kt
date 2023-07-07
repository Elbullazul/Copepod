package dev.elbullazul.copepod.backends.kbin

import dev.elbullazul.copepod.backends.common.Wrapper
import dev.elbullazul.copepod.backends.common.models.Post
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_COMMENTS
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_THREADS

class KbinWrapper(server: String = "kbin.social"): Wrapper(server) {
    override fun Login(token: String): Boolean {
        return true
    }

    override fun Logout() {
    }

    override fun Feed(path: String): List<Post> {
        return emptyList()
    }

    override fun Post(id: String): Post {
        // TODO: for tests only
        val post1 = TEST_K_THREADS[0]
        val post2 = TEST_K_THREADS[1]
        val post3 = TEST_K_THREADS[2]
        val post4 = TEST_K_THREADS[3]

        val comment1 = TEST_K_COMMENTS[0]
        val comment2 = TEST_K_COMMENTS[1]
        val comment3 = TEST_K_COMMENTS[2]
        val comment4 = TEST_K_COMMENTS[3]

        comment1.root = post1
        comment2.root = post1
        comment3.root = post1

        post1.replies = listOf(
            comment1,
            comment2,
            comment3
        )

        return post1
    }

    override fun List(id: String): List<Post> {
        return emptyList()
    }

    override fun Group(id: String): List<Post> {
        return emptyList()
    }

    override fun Search(query: String): List<Post> {
        return emptyList()
    }

    override fun ActorPosts(id: String, server: String): List<Post> {
        return emptyList()
    }

    override fun ActorReplies(id: String, server: String): List<Post> {
        return emptyList()
    }

    override fun ActorBoosts(id: String, server: String): List<Post> {
        return emptyList()
    }
}