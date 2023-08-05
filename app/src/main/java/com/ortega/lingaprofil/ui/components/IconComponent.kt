package com.ortega.lingaprofil.ui.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconComponent(icon: ImageVector, description: String?=null) {
    Icon(imageVector = icon, contentDescription = description)
}