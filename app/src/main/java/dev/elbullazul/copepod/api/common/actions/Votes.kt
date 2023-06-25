package dev.elbullazul.copepod.api.common.actions

interface Votes {
    var upvotes: Int
    var downvotes: Int
    var vote: Int
}

var UPVOTED = 1
var NOT_VOTED = 0
var DOWNVOTED = -1