package dev.elbullazul.copepod.api.common.models

import java.util.Date
import dev.elbullazul.copepod.api.kbin.models.User

abstract class Post() {
    // empty constructor for tests only
    var creator: User = User()
    var created: Date = Date()
    var body: String = ""
    var url: String = ""
    var originUrl: String = ""  // not empty if from remote instance
    var replies: List<Post> = emptyList()

    // leave actions (upvote, boost, reactions, etc.) to be implemented by their respective services
    // kbin: upvote, downvote, boost, save?
    // lemmy: upvote, downvote, save
    // calckey/misskey: like?, reactions, boost (3 types), bookmark
    // mastodon: like, boost (3 types), bookmark

    constructor(creator: User, created: Date, body: String, url: String, originUrl: String, replies: List<Post>): this() {
        this.creator = creator
        this.created = created
        this.body = body
        this.url = url
        this.originUrl = originUrl
        this.replies = replies
    }
}