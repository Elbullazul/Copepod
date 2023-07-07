package dev.elbullazul.copepod.backends.calckey.models

import dev.elbullazul.copepod.backends.common.features.Avatar
import dev.elbullazul.copepod.backends.common.features.Description
import dev.elbullazul.copepod.backends.common.features.DisplayName
import dev.elbullazul.copepod.backends.common.models.Actor
import dev.elbullazul.copepod.backends.common.types.ActorType

class CUser(
    id: String = "",
    name: String = "",

    userId: String = "",    // calckey user ID

    override var avatar: String = "",
    override var displayName: String = "",
    override var description: String = ""
): Actor(id, name, ActorType.PERSON),
    Avatar, DisplayName, Description