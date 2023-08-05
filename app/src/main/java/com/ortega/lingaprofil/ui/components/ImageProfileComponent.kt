package com.ortega.lingaprofil.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.ui.theme.LingaProfilTheme

@Composable
fun ImageProfileComponent(image: String, name: String) {

    if (image == "") {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(size = 50.dp)
                .clip(shape = RoundedCornerShape(size = 25.dp))
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
        ) {

            Text(text = "${name[0]}")

        }
    } else {
        Image(
            modifier = Modifier
                .size(size = 50.dp)
                .clip(shape = RoundedCornerShape(size = 25.dp)),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = stringResource(id = R.string.image)
        )
    }

}

