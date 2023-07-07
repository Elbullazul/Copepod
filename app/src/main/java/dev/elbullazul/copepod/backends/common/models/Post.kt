package dev.elbullazul.copepod.backends.common.models

import java.util.Date
import dev.elbullazul.copepod.backends.kbin.models.KUser

abstract class Post(
    var id: String = "",
    var creator: KUser = KUser(),
    var created: Date = Date(),
    var body: String = "",
    var url: String = "",
    var replies: List<Post> = emptyList(),
    var root: Post? = null,
    var parent: Post? = null,
)