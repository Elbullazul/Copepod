package dev.elbullazul.copepod.backends.common.models

import dev.elbullazul.copepod.backends.common.types.ActorType

abstract class Actor(
    var id: String = "",
    var name: String = "",
    var type: ActorType,
    var following: Int = 0,  // should be list of Actors?
    var followers: Int = 0  // should be list of Actors?
)