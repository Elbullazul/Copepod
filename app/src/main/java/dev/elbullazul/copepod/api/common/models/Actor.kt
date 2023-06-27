package dev.elbullazul.copepod.api.common.models

abstract class Actor(
    var id: String = "",
    var name: String = "",
    var type: String = "",
    var following: Int = 0,  // should be list of Actors?
    var followers: Int = 0  // should be list of Actors?
) {
}

val PERSON_ACTOR = "Person"
val GROUP_ACTOR = "Group"