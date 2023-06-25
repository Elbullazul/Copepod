package dev.elbullazul.copepod.ui.fragments.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import dev.elbullazul.copepod.api.kbin.data.TEST_MAGAZINES
import dev.elbullazul.copepod.ui.fragments.cards.ProfileCard

@Composable
fun MagazineListView() {
    LazyColumn() {
        for (mag in TEST_MAGAZINES) {
            item {
                ProfileCard(actor = mag)
            }
        }
    }
}