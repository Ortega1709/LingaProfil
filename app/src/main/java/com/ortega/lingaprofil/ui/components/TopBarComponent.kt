package com.ortega.lingaprofil.ui.components

import android.app.Activity
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    title: String,
    icon: ImageVector = Icons.Rounded.ArrowBack,
    action:  @Composable() (RowScope.() -> Unit) = {},
    scrollBehavior: TopAppBarScrollBehavior?
) {

    val context = LocalContext.current

    LargeTopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                (context as? Activity)?.finish()
            }) {
                Icon(imageVector = icon, contentDescription = null)
            }
        },
        title = {
            TextComponent(text = title)
        },
        actions = action,
        scrollBehavior = scrollBehavior
    )

}