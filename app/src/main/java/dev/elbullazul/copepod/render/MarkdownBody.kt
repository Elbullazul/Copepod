package dev.elbullazul.copepod.render

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// TODO: implement or wrap around exisitng library
@Composable
fun MarkdownBody(source: String) {
    // divide in chunks based on type (text, image, video, spoiler, quote, etc.)

    // assemble body

    // return body
    Column(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)) {
        Text(source)
    }
}