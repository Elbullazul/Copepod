package dev.elbullazul.copepod.backends.kbin.models

import dev.elbullazul.copepod.backends.common.features.Avatar
import dev.elbullazul.copepod.backends.common.features.Description
import dev.elbullazul.copepod.backends.common.features.DisplayName
import dev.elbullazul.copepod.backends.common.models.Actor
import dev.elbullazul.copepod.backends.common.types.ActorType

class KMagazine(
    id: String = "",
    name: String = "",

    override var avatar: String = "",
    override var description: String = "",
    override var displayName: String = ""
): Actor(id, name, ActorType.GROUP),
    Avatar, DisplayName, Description