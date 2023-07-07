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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.elbullazul.copepod.R
import dev.elbullazul.copepod.backends.common.features.Avatar
import dev.elbullazul.copepod.backends.common.features.Description
import dev.elbullazul.copepod.backends.common.models.Actor
import dev.elbullazul.copepod.backends.common.types.ActorType
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_THREADS
import dev.elbullazul.copepod.backends.kbin.data.TEST_K_USERS
import dev.elbullazul.copepod.ui.theme.CopepodTheme

// TODO: could be reused for magazine/community header

@Composable
fun ActorCard(actor: Actor) {
    Column(modifier = Modifier.padding(15.dp)) {
        Row {
            // TODO: show avatar if available
            if (actor is Avatar) {
                Icon(Icons.Outlined.Person, contentDescription = "User avatar")
            }

            Text(text = actor.name, modifier = Modifier.padding(horizontal = 5.dp))

            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${actor.followers} ${stringResource(R.string.followers)}", color = MaterialTheme.colorScheme.secondary)
        }
        if (actor is Description) {
            Text(actor.description, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActorCardPreview() {
    CopepodTheme {
        Column {
            ActorCard(TEST_K_USERS[0])
        }
    }
}