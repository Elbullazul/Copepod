package dev.elbullazul.copepod.backends.kbin.models

import dev.elbullazul.copepod.backends.common.models.Post
import dev.elbullazul.copepod.backends.common.features.Boosts
import dev.elbullazul.copepod.backends.common.features.Votes
import dev.elbullazul.copepod.backends.common.types.VoteStatus
import java.util.Date

class KComment(
    id: String = "",
    creator: KUser = KUser(),
    created: Date = Date(),
    body: String = "",
    url: String = "",
    replies: List<Post> = emptyList(),
    root: Post? = null,
    parent: Post? = null,

    override var vote: VoteStatus = VoteStatus.NOT_VOTED,
    override var upvotes: Int = 0,
    override var downvotes: Int = 0,

    override var boosts: Int = 0,
    override var boosted: Boolean = false
): Post(id, creator, created, body, url, replies, root, parent),
    Votes, Boosts