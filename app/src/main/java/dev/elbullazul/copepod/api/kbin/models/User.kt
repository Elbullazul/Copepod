package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.User

class User(userId: String, userName: String, userUrl: String):
    User(userId, userName, userUrl) {

    // TODO: move to common user (or drop and integrate into userId)
    var homeserver: String = ""

    // KBin extensions
    var following: Int = 0
    var followers: Int = 0
    var boosts: Int = 0
}