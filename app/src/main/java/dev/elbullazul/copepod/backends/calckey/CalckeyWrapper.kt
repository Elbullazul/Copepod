package dev.elbullazul.copepod.backends.calckey

import dev.elbullazul.copepod.backends.calckey.models.CNote
import dev.elbullazul.copepod.backends.common.Wrapper
import dev.elbullazul.copepod.backends.common.models.Post

class CalckeyWrapper(server: String = "calckey.social"): Wrapper(server) {
    override fun Login(token: String): Boolean {
        return true
    }

    override fun Logout() {
    }

    override fun Feed(path: String): List<Post> {
        return emptyList()
    }

    override fun Post(id: String): Post {
        return CNote()
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