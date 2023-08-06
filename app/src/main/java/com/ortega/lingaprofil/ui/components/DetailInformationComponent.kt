package com.ortega.lingaprofil.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person3
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Work
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.data.datasource.ProfileEntity

@Composable
fun DetailInformationComponent(profile: ProfileEntity) {

    Card (
        shape = RoundedCornerShape(size = 16.dp),
        colors = CardDefaults.cardColors(
            contentColor = if (isSystemInDarkTheme()) colorResource(id = R.color.my_custom_color) else colorResource(id = R.color.my_custom_color_white)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        
        ItemInformationComponent(icon = null, text = stringResource(R.string.informations), onClickItem = {})


        ItemInformationComponent(icon = Icons.Rounded.Person3, text = profile.name, onClickItem = {})
        ItemInformationComponent(icon = Icons.Rounded.Phone, text = profile.phone, onClickItem = {})
        ItemInformationComponent(icon = Icons.Rounded.Work, text = profile.profession, onClickItem = {})
        ItemInformationComponent(icon = Icons.Rounded.Email, text = profile.email, onClickItem = {})
        ItemInformationComponent(icon = Icons.Rounded.Home, text = profile.address, onClickItem = {})


    }

}