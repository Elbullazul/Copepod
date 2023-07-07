package dev.elbullazul.copepod.backends.common.features

import dev.elbullazul.copepod.backends.common.types.VoteStatus

interface Votes {
    var upvotes: Int
    var downvotes: Int
    var vote: VoteStatus
}