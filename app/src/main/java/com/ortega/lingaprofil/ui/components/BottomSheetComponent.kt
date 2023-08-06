package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AmpStories
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.Photo
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(
    onDismiss: () -> Unit,
    onClickCamera: () -> Unit,
    onClickGallery: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column (
            modifier = Modifier.padding(bottom = 32.dp)
        ) {

            ListItem(
                modifier = Modifier.clickable { onClickCamera() },
                leadingContent = { IconComponent(icon = Icons.Rounded.CameraAlt) },
                headlineContent = { TextComponent(text = stringResource(R.string.photo)) },
            )
            ListItem(
                modifier = Modifier.clickable { onClickGallery() },
                leadingContent = { IconComponent(icon = Icons.Rounded.Photo) },
                headlineContent = { TextComponent(text = stringResource(R.string.gallerie_photos)) },
            )

        }
    }
}