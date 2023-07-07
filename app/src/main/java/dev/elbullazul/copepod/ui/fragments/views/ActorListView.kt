package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_MAGAZINES
import dev.elbullazul.copepod.ui.fragments.cards.ActorCard

@Composable
fun ActorListView() {
    LazyColumn() {
        // TODO: load actors based on user subscription or server results
        val actors = TEST_K_MAGAZINES

        for (actor in actors) {
            item {
                ActorCard(actor = actor)
            }
        }
    }
}