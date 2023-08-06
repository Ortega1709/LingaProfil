package com.ortega.lingaprofil.ui.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R

@Composable
fun DetailImageProfileComponent(image: String, name: String) {

    if (image == "") {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(size = 250.dp)
                    .background(color = MaterialTheme.colorScheme.secondaryContainer),
            ) {

                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null,
                    modifier = Modifier.size(size = 50.dp)
                )

            }

        }
    } else {

        val bitmap = BitmapFactory.decodeFile(image).asImageBitmap()

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 250.dp),
            bitmap = bitmap,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.image)
        )
    }

}