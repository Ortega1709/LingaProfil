package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.ui.theme.LingaProfilTheme

@Composable
fun TextFieldComponent(
    value: String,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            IconComponent(icon = icon)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        value = value,
        label = { Text(text = label) },
        onValueChange = onValueChange
    )

}

@Composable
@Preview
fun TextFieldComponentPreview() {
    LingaProfilTheme {
        var value by rememberSaveable {
            mutableStateOf("")
        }
        TextFieldComponent(
            value = value,
            label = stringResource(R.string.name),
            onValueChange = { value = it },
            icon = Icons.Default.StarBorder
        )
    }
}