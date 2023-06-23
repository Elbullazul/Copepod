package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.Post
import java.util.Date

class Comment(creator: User, created: Date, body: String, url: String, originUrl: String, replies: List<Post>, /*parent: Thread,*/ upvotes: Int, downvotes: Int, boosts: Int):
    Post(creator, created, body, url, originUrl, replies), Actions {
    //var parent: Thread = parent
    var depth: Int = 0

    override var upvotes = upvotes
    override var downvotes = downvotes
    override var boosts = boosts
}