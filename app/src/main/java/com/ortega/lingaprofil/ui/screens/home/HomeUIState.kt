package com.ortega.lingaprofil.ui.screens.home

import com.ortega.lingaprofil.data.datasource.ProfileEntity

data class HomeUIState(
    val profileList: List<ProfileEntity> = emptyList(),
    var currentProfile: ProfileEntity? = null
)
