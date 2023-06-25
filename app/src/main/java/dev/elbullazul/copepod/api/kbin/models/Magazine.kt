package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.models.GROUP_ACTOR
import dev.elbullazul.copepod.api.common.models.Actor

class Magazine(): Actor() {
    // move to common interface?
    // have to be manually set?
    var avatar: String = ""
    var displayName: String = ""

    constructor(id: String, name: String):this() {
        this.id = id    // doubles as URL?
        this.name = name
        this.type = GROUP_ACTOR
    }
}