package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SnackBarComponent(
    message: String,
    onActionClick: () -> Unit
) {

    Snackbar(
        modifier = Modifier.padding(all = 16.dp),
        action = {
            IconButton(onClick = onActionClick) {
                IconComponent(icon = Icons.Rounded.Close)
            }
        }
    ) {
        TextComponent(text = message)
    }

}