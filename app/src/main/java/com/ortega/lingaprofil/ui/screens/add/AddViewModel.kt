package com.ortega.lingaprofil.ui.screens.add

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.lingaprofil.data.datasource.ProfileEntity
import com.ortega.lingaprofil.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val profileRepository: ProfileRepository): ViewModel() {


    fun saveProfile(profile: ProfileEntity) {
        viewModelScope.launch {
            profileRepository.insert(profile = profile)
        }
    }

    fun saveImageToInternalStorage(context: Context, uri: Uri): String {
        val inputStream = context.contentResolver.openInputStream(uri)
        val destinationFile = File(context.filesDir, "img_${System.currentTimeMillis()}.jpg")
        inputStream?.use { input ->
            destinationFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        return destinationFile.absolutePath
    }

}