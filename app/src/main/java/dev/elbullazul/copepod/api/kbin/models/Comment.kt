package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.models.Post
import dev.elbullazul.copepod.api.common.interfaces.Boosts
import dev.elbullazul.copepod.api.common.interfaces.VoteStatus
import dev.elbullazul.copepod.api.common.interfaces.Votes
import java.util.Date

class Comment(
    id: String = "",
    creator: User = User(),
    created: Date = Date(),
    body: String = "",
    url: String = "",
    originUrl: String = "",
    replies: List<Post> = emptyList(),

    override var vote: Int = VoteStatus.NOT_VOTED,
    override var upvotes: Int = 0,
    override var downvotes: Int = 0,

    override var boosts: Int = 0,
    override var boosted: Boolean = false
):Post(id, creator, created, body, url, originUrl, replies),
    Votes, Boosts