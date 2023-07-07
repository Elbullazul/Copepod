package dev.elbullazul.copepod.backends.kbin.models

import dev.elbullazul.copepod.backends.common.features.Avatar
import dev.elbullazul.copepod.backends.common.features.DisplayName
import dev.elbullazul.copepod.backends.common.models.Actor
import dev.elbullazul.copepod.backends.common.types.ActorType

class KUser(
    id: String = "",
    name: String = "",

    userId: String = "",    // kbin-specific user ID

    override var avatar: String = "",
    override var displayName: String = "",
): Actor(id, name, ActorType.PERSON),
    Avatar, DisplayName
