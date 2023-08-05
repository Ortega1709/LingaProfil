package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.data.datasource.ProfileEntity

@Composable
fun CountItemComponent(profileList: List<ProfileEntity>) {

    Column {
        Text(
            text = "${profileList.size} ${stringResource(id = R.string.profiles)}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary)
    }

}