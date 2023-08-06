package com.ortega.lingaprofil.ui.screens.detail

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.ModeEditOutline
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.ui.components.BottomSheetComponent
import com.ortega.lingaprofil.ui.components.ConfirmComponent
import com.ortega.lingaprofil.ui.components.DetailImageProfileComponent
import com.ortega.lingaprofil.ui.components.DetailInformationComponent
import com.ortega.lingaprofil.ui.components.TextComponent
import com.ortega.lingaprofil.ui.components.TopBarComponent
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(viewModel: DetailViewModel = hiltViewModel(), id: Int) {

    var uiState = viewModel.uiState
    val context = LocalContext.current

    if (id > 0) {
        viewModel.getProfile(id = id)
    } else {
        (context as? Activity)?.finish()
    }

    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold (
        topBar = {
            TopBarComponent(
                title = stringResource(id = R.string.profile),
                action = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = stringResource(id = R.string.edit)
                        )
                    }
                    IconButton(onClick = {
                        viewModel.favoriteUpdate(!uiState.currentProfile.isFavorite, id)
                    }) {
                        if (uiState.currentProfile.isFavorite) {
                            Icon(
                                imageVector = Icons.Rounded.Star,
                                contentDescription = stringResource(id = R.string.favorite)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Rounded.StarBorder,
                                contentDescription = stringResource(id = R.string.favorite)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(width = 4.dp))
                },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {

        Column (
            modifier = Modifier
                .padding(it)
        ) {
            
            DetailImageProfileComponent(
                image = uiState.currentProfile.image,
                name = uiState.currentProfile.name
            )
            
            DetailInformationComponent(profile = uiState.currentProfile)

        }

    }



}