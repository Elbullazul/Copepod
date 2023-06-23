package dev.elbullazul.copepod.ui.helpers

import android.content.Context
import android.widget.Toast

fun ShowToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}