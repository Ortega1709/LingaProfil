package com.ortega.lingaprofil.ui.components

import android.content.res.Configuration
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ortega.lingaprofil.ui.theme.LingaProfilTheme

@Composable
fun ChipComponent(text: String, onClickChip: ()->Unit, active: Boolean) {

    AssistChip(
        onClick = { onClickChip() },
        label = { Text(text = text) }
    )
}

@Composable
@Preview
fun ChipComponentPreview() {
    LingaProfilTheme {
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ChipComponentPreviewDark() {
    LingaProfilTheme {
    }
}

