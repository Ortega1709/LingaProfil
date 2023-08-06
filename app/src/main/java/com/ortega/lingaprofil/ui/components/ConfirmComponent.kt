package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Photo
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ortega.lingaprofil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmComponent(
    onDismiss: () -> Unit,
    onClickDelete: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column (
            modifier = Modifier.padding(bottom = 32.dp)
        ) {

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 14.sp,
                text = stringResource(R.string.are_you_sure)
            )

            ListItem(
                modifier = Modifier.clickable { onClickDelete() },
                leadingContent = { IconComponent(icon = Icons.Rounded.Delete) },
                headlineContent = { TextComponent(text = stringResource(R.string.delete)) },
            )

        }
    }
}