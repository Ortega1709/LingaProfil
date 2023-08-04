package com.ortega.lingaprofil.ui.screens.home

import com.ortega.lingaprofil.data.datasource.ProfileEntity

data class UIState(
    val profileList: List<ProfileEntity> = emptyList()
)
