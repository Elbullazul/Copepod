package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.api.common.actions.Boosts
import dev.elbullazul.copepod.api.common.actions.Favorites
import dev.elbullazul.copepod.api.common.actions.Votes
import java.util.Date

class Comment(creator: User, created: Date, body: String, url: String, originUrl: String, replies: List<Post>, upvotes: Int, downvotes: Int, boosts: Int):
    Post(creator, created, body, url, originUrl, replies),
    Votes, Boosts, Favorites {

    // assign manually
    var parent: Post? = null
    var root: Post? = null

    override var upvotes = upvotes
    override var downvotes = downvotes
    override var boosts = boosts
    override var favorites = 0  // not used?

    constructor(creator: User, created: Date, body: String, url: String, originUrl: String, replies: List<Post>, upvotes: Int, downvotes: Int, boosts: Int, parent: Post)
        :this(creator, created, body, url, originUrl, replies, upvotes, downvotes, boosts) {

        this.parent = parent
    }
}