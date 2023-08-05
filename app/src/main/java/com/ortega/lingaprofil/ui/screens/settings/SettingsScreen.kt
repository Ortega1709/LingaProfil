package com.ortega.lingaprofil.ui.screens.settings

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.ui.components.TextComponent
import com.ortega.lingaprofil.ui.components.TopBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {

    val context = LocalContext.current

    Scaffold (
        topBar = {
            TopBarComponent(
                title = stringResource(id = R.string.settings_description),
                scrollBehavior = null
            )
        }
    ) {

        Column (
            modifier = Modifier
                .padding(it)
                .padding(all = 16.dp)
        ) {



        }

    }

}