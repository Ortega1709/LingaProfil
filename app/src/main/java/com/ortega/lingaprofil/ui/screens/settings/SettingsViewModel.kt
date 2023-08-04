package com.ortega.lingaprofil.ui.screens.settings

import androidx.lifecycle.ViewModel
import com.ortega.lingaprofil.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val profileRepository: ProfileRepository): ViewModel() {



}