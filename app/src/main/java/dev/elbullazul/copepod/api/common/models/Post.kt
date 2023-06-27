package dev.elbullazul.copepod.api.common.models

import java.util.Date
import dev.elbullazul.copepod.api.kbin.models.User

abstract class Post(
    var id: String = "",
    var creator: User = User(),
    var created: Date = Date(),
    var body: String = "",
    var url: String = "",
    var originUrl: String = "",
    var replies: List<Post> = emptyList(),
    var parent: Post? = null,
    var root: Post? = null,
)