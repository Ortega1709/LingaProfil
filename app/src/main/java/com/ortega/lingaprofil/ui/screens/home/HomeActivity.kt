package com.ortega.lingaprofil.ui.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ortega.lingaprofil.ui.theme.LingaProfilTheme
import dagger.hilt.EntryPoint

@EntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LingaProfilTheme {

            }
        }
    }
}

