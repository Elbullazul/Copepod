package dev.elbullazul.copepod.api.common

abstract class User(userId: String, userUrl: String, userName: String) {
    var userId: String = userId
    var userUrl: String = userUrl
    var userName: String = userName

    // unsure about these
    // outbox (posts, replies, etc)
}