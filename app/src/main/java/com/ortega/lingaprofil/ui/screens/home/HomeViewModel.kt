package com.ortega.lingaprofil.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.lingaprofil.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val profileRepository: ProfileRepository): ViewModel() {

    var uiState by mutableStateOf(HomeUIState())

    init { getProfiles() }

    fun getProfiles() {
        viewModelScope.launch {
            profileRepository.getAll().collect {profile ->
                uiState = uiState.copy(
                    profileList = profile
                )
            }
        }
    }

}