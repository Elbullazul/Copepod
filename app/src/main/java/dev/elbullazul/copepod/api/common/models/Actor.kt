package dev.elbullazul.copepod.api.common.models

abstract class Actor() {
    var id: String = ""
    var type: String = ""
    var name: String = ""

    // not relevant for Groups (ex. magazines, communities, lists?)
    var following: Int = 0  // should be list of Actors?
    var followers: Int = 0  // should be list of Actors?

    constructor(id: String, name: String, type: String):this() {
        this.id = id
        this.type = type
        this.name = name
    }
}

val PERSON_ACTOR = "Person"
val GROUP_ACTOR = "Group"