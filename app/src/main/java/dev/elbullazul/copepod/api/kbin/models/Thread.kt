package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.api.common.actions.Boosts
import dev.elbullazul.copepod.api.common.actions.Favorites
import dev.elbullazul.copepod.api.common.actions.Votes
import java.util.Date

class Thread(): Post(),
    Votes, Boosts, Favorites {

    var title: String = ""
    var magazine: Magazine = Magazine()

    override var upvotes = 0
    override var downvotes = 0
    override var boosts = 0
    override var favorites = 0  // not used?

    constructor(creator: User, created: Date, title: String, magazine: Magazine, body: String, url: String, originUrl: String, replies: List<Post>, upvotes: Int, downvotes: Int, boosts: Int):this() {
        this.creator = creator
        this.created = created
        this.title = title
        this.magazine = magazine
        this.body = body
        this.url = url
        this.originUrl = originUrl
        this.replies = replies

        this.upvotes = upvotes
        this.downvotes = downvotes
        this.boosts = boosts
    }
}