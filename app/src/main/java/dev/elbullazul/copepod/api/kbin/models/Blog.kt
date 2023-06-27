package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.interfaces.Boosts
import dev.elbullazul.copepod.api.common.models.Post
import java.util.Date

class Blog(
    id: String = "",
    creator: User = User(),
    created: Date = Date(),
    body: String = "",
    url: String = "",
    originUrl: String = "",
    replies: List<Post> = emptyList(),

    override var boosts: Int = 0,
    override var boosted: Boolean = false
): Post(id, creator, created, body, url, originUrl, replies),Boosts