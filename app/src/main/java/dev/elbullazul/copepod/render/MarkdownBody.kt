package dev.elbullazul.copepod.render

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: implement or wrap around exisitng library
@Composable
fun MarkdownBody(source: String, onClick: (Int) -> Unit = {}) {
    // divide in chunks based on type (text, image, video, spoiler, quote, etc.)

    // assemble body

    // return body
    Column(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)) {
//        Text(source)
        ClickableText(
            text = AnnotatedString(source),
            style = TextStyle(
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.inverseSurface
            ),
            onClick = onClick
        )
    }
}