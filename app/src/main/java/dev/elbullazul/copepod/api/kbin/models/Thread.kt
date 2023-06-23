package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.Post
import java.util.Date

class Thread(): Post(), Actions {

    var title: String = ""

    override var upvotes = 0
    override var downvotes = 0
    override var boosts = 0

    constructor(creator: User, created: Date, title: String, body: String, url: String, originUrl: String, replies: List<Post>, upvotes: Int, downvotes: Int, boosts: Int):this() {
        this.creator = creator
        this.created = created
        this.title = title
        this.body = body
        this.url = url
        this.originUrl = originUrl
        this.replies = replies

        this.upvotes = upvotes
        this.downvotes = downvotes
        this.boosts = boosts
    }
}