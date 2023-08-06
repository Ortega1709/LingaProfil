package com.ortega.lingaprofil.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.data.datasource.ProfileEntity
import com.ortega.lingaprofil.ui.theme.LingaProfilTheme

@Composable
fun ProfileItemComponent(profile: ProfileEntity, onClickItem: () -> Unit, onClickDelete: () -> Unit) {

    ListItem(
        modifier = Modifier.clickable { onClickItem() },
        leadingContent = {
            ImageProfileComponent(image = profile.image, name = profile.name)
        },
        headlineContent = {
            Text(
                text = profile.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },

        overlineContent = {
            Text(
                text = profile.profession,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        trailingContent = {
            IconButton(onClick = onClickDelete ) {
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = stringResource(id = R.string.delete)
                )
            }
        }
    )

    Divider(
        modifier = Modifier.height(height = .5.dp)
    )

}

