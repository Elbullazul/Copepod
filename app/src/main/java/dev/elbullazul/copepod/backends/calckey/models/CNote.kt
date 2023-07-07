package dev.elbullazul.copepod.backends.calckey.models

import dev.elbullazul.copepod.backends.common.features.Bookmarks
import dev.elbullazul.copepod.backends.common.features.Boosts
import dev.elbullazul.copepod.backends.common.features.Reactions
import dev.elbullazul.copepod.backends.common.models.Post
import dev.elbullazul.copepod.backends.common.types.Reaction
import dev.elbullazul.copepod.backends.kbin.models.KUser
import java.util.Date

class CNote(
    id: String = "",
    creator: KUser = KUser(),
    created: Date = Date(),
    body: String = "",
    url: String = "",
    replies: List<Post> = emptyList(),
    root: Post? = null,
    parent: Post? = null,

    override var boosts: Int = 0,
    override var boosted: Boolean = false,

    override var bookmarked: Boolean = false,

    override var reactions: List<Reaction> = emptyList(),
    override var reacted: Reaction = Reaction(),
): Post(id, creator, created, body, url, replies, root, parent),
    Boosts, Bookmarks, Reactions