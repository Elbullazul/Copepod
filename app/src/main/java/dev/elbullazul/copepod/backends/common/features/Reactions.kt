package dev.elbullazul.copepod.backends.common.features

import dev.elbullazul.copepod.backends.common.types.Reaction

interface Reactions {
    var reactions: List<Reaction>
    var reacted: Reaction
}