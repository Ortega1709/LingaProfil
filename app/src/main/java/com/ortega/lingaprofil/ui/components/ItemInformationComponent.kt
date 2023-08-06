package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ortega.lingaprofil.R

@Composable
fun ItemInformationComponent(
    icon: ImageVector? = null,
    text: String,
    onClickItem: () -> Unit
) {

    ListItem(
        modifier = Modifier.clickable { onClickItem() },
        leadingContent = { IconComponent(icon = icon!!) },
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        headlineContent = {
            TextComponent(text = if (text == "") stringResource(R.string.no_informations) else text )
        },
    )

}