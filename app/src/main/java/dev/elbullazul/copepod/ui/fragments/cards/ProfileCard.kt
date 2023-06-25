package dev.elbullazul.copepod.ui.fragments.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.api.common.models.Actor
import dev.elbullazul.copepod.api.common.models.PERSON_ACTOR

// TODO: could be reused for magazine/community header

@Composable
fun ProfileCard(actor: Actor) {
    Column(modifier = Modifier.padding(15.dp)) {
        Row {
            if (actor.type == PERSON_ACTOR) {
                Icon(Icons.Outlined.Person, contentDescription = "user avatar")
            }
            else {
                Icon(Icons.Outlined.Info, contentDescription = "group avatar")
            }
            Text(text = actor.name, modifier = Modifier.padding(horizontal = 5.dp))

            // TODO: number of followers?
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${actor.followers} ${stringResource(R.string.followers)}", color = MaterialTheme.colorScheme.secondary)
        }
        Text("<description goes here>", modifier = Modifier.padding(vertical = 10.dp))
    }
}