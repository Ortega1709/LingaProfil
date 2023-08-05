package com.ortega.lingaprofil.ui.screens.home

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.ui.components.ChipComponent
import com.ortega.lingaprofil.ui.components.CountItemComponent
import com.ortega.lingaprofil.ui.components.PaddingBottomComponent
import com.ortega.lingaprofil.ui.components.ProfileItemComponent
import com.ortega.lingaprofil.ui.screens.add.AddActivity
import com.ortega.lingaprofil.ui.screens.detail.DetailActivity
import com.ortega.lingaprofil.ui.screens.settings.SettingsActivity
import com.ortega.lingaprofil.ui.theme.LingaProfilTheme

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val uiState = viewModel.uiState
    val context = LocalContext.current

    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Column {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = if (active) 0.dp else 16.dp,
                            end = if (active) 0.dp else 16.dp
                        ),
                    query = query,
                    placeholder = { Text(text = stringResource(id = R.string.search_description)) },
                    onQueryChange = { query = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = { active = it },
                    leadingIcon = {
                        if (active) {
                            IconButton(onClick = { active = false }) {
                                Icon(
                                    imageVector = Icons.Rounded.ArrowBack,
                                    contentDescription = stringResource(id = R.string.settings_description)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = stringResource(id = R.string.search_description)
                            )
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            context.startActivity(Intent(context, SettingsActivity::class.java))
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.Settings,
                                contentDescription = stringResource(id = R.string.settings_description)
                            )
                        }

                    }
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background)
                    ) {

                        items(count = 20) {
                            ProfileItemComponent(
                                onClickItem = {
                                    context.startActivity(
                                        Intent(context, DetailActivity::class.java).also {
                                            it.putExtra("id", 1)
                                        }
                                    )
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(height = 8.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row {
                        ChipComponent(text = stringResource(id = R.string.all), onClickChip = {}, active = false)
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        ChipComponent(text = stringResource(id = R.string.favorite), onClickChip = {}, active = false)
                    }

                    CountItemComponent(profileList = emptyList())

                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = stringResource(id = R.string.add)) },
                icon = { Icon(imageVector = Icons.Rounded.Add, contentDescription = null) },
                onClick = {
                    context.startActivity(Intent(context, AddActivity::class.java))
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(top = 16.dp, bottom = 16.dp)
        ) {

            items(count = 20) {
                ProfileItemComponent(
                    onClickItem = {
                        context.startActivity(
                            Intent(context, DetailActivity::class.java).also {
                                it.putExtra("id", 1)
                            }
                        )
                    }
                )
            }


            item {
                PaddingBottomComponent()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeScreenPreview() {
    LingaProfilTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeScreenPreviewDark() {
    LingaProfilTheme {
        HomeScreen()
    }
}