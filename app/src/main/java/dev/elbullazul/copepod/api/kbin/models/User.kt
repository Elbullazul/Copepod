package dev.elbullazul.copepod.api.kbin.models

import dev.elbullazul.copepod.api.common.interfaces.Avatar
import dev.elbullazul.copepod.api.common.interfaces.DisplayName
import dev.elbullazul.copepod.api.common.models.PERSON_ACTOR
import dev.elbullazul.copepod.api.common.models.Actor

class User(
    id: String = "",
    name: String = "",

    override var avatar: String = "",
    override var displayName: String = "",
): Actor(id, name, PERSON_ACTOR),
    Avatar, DisplayName
