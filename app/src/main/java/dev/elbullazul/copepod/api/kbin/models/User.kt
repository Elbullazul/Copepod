package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.models.PERSON_ACTOR
import dev.elbullazul.copepod.api.common.models.Actor

class User(): Actor() {
    var avatar: String = ""         // TODO: move elsewhere? (ex. share with mastodon, lemmy, etc.)
    var displayName: String = ""    // TODO: share with microblog services (when implemented)
    var boosts: Int = 0             // TODO: share with microblog services (when implemented)

    constructor(id: String, name: String):this() {
        this.id = id
        this.name = name
        this.type = PERSON_ACTOR
    }
}