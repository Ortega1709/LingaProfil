package com.ortega.lingaprofil.ui.screens.detail

import com.ortega.lingaprofil.data.datasource.ProfileEntity

data class DetailUIState(
    val currentProfile: ProfileEntity = ProfileEntity(
        0,
        "",
        "",
        "",
        "",
        "",
        "",
        false)
)
