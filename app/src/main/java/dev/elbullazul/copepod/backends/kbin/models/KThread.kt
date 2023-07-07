package dev.elbullazul.copepod.backends.kbin.models

import dev.elbullazul.copepod.backends.common.models.Post
import dev.elbullazul.copepod.backends.common.features.Boosts
import dev.elbullazul.copepod.backends.common.features.Description
import dev.elbullazul.copepod.backends.common.features.GroupMember
import dev.elbullazul.copepod.backends.common.features.Title
import dev.elbullazul.copepod.backends.common.features.Votes
import dev.elbullazul.copepod.backends.common.models.Actor
import dev.elbullazul.copepod.backends.common.types.VoteStatus
import java.util.Date

class KThread(
    id: String = "",
    creator: KUser = KUser(),
    created: Date = Date(),
    body: String = "",
    url: String = "",
    replies: List<Post> = emptyList(),

    override var description: String = "",  // short preview of the body

    override var group: Actor = KMagazine(),

    override var vote: VoteStatus = VoteStatus.NOT_VOTED,
    override var title: String = "",
    override var upvotes: Int = 0,
    override var downvotes: Int = 0,

    override var boosts: Int = 0,
    override var boosted: Boolean = false
): Post(id, creator, created, body, url, replies),
    Votes, Boosts, Title, GroupMember, Description