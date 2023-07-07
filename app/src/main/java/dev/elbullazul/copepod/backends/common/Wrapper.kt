package dev.elbullazul.copepod.backends.common

import dev.elbullazul.copepod.backends.common.models.Post

abstract class Wrapper(server: String) {
    var server: String = server     // homeserver URL
    var token: String = ""

    abstract fun Login(token: String): Boolean
    abstract fun Logout()

    abstract fun Feed(path: String): List<Post>
    abstract fun Post(id: String): Post
    abstract fun List(id: String): List<Post>       // microblog service only
    abstract fun Group(id: String): List<Post>      // community/magazine (threaded?) service only
    abstract fun Search(query: String): List<Post>

    // server argument not empty when server is different and loading post directly (not yet federated or not at all)
    abstract fun ActorPosts(id: String, server: String = ""):List<Post>
    abstract fun ActorReplies(id: String, server: String = ""):List<Post>
    abstract fun ActorBoosts(id: String, server: String = ""):List<Post>
}