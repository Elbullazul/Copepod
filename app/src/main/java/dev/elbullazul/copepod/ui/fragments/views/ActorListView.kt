package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import dev.elbullazul.copepod.api.kbin.data.TEST_MAGAZINES
import dev.elbullazul.copepod.ui.fragments.cards.PreviewCard

@Composable
fun ActorListView() {
    LazyColumn() {
        // TODO: load actors based on user subscription or server results
        val actors = TEST_MAGAZINES

        for (actor in actors) {
            item {
                PreviewCard(actor = actor)
            }
        }
    }
}