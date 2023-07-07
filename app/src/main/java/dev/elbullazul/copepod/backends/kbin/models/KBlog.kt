package dev.elbullazul.copepod.backends.kbin.models

import dev.elbullazul.copepod.backends.common.features.Boosts
import dev.elbullazul.copepod.backends.common.models.Post
import java.util.Date

class KBlog(
    id: String = "",
    creator: KUser = KUser(),
    created: Date = Date(),
    body: String = "",
    url: String = "",
    replies: List<Post> = emptyList(),
    root: Post? = null,
    parent: Post? = null,

    override var boosts: Int = 0,
    override var boosted: Boolean = false
): Post(id, creator, created, body, url, replies, root, parent),
    Boosts