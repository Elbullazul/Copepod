package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.api.common.actions.Boosts
import dev.elbullazul.copepod.api.common.actions.Favorites
import dev.elbullazul.copepod.api.common.actions.Votes
import java.util.Date

class Comment():
    Post(),
    Votes, Boosts {

    // assign manually
    var parent: Post? = null
    var root: Post? = null

    override var upvotes = 0
    override var downvotes = 0
    override var boosts = 0

    override var vote = 0  // not voted
    override var boosted = false

    constructor(creator: User, created: Date, body: String, url: String, originUrl: String, replies: List<Post>, upvotes: Int, downvotes: Int, boosts: Int)
        :this() {

        this.creator = creator
        this.created = created
        this.body = body
        this.url = url
        this.originUrl = originUrl
        this.replies = replies

        this.upvotes = upvotes
        this.downvotes = downvotes
        this.boosts = boosts
    }
}