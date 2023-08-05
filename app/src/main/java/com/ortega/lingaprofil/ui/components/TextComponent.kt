package com.ortega.lingaprofil.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TextComponent(text: String) {

    Text(
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )

}