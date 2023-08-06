package com.ortega.lingaprofil.ui.components

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddPhotoAlternate
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.lingaprofil.R

@Composable
fun ImageFieldComponent(
    imageUri: Uri? = null,
    onClickImageField: () -> Unit,
    onClickDelete: () -> Unit,
    onClickAddPicture: () -> Unit
) {

    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (imageUri == null) {
            Column {

                Box (
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(size = 130.dp)
                        .clip(shape = RoundedCornerShape(size = 65.dp))
                        .clickable { onClickImageField() }
                        .background(color = MaterialTheme.colorScheme.secondaryContainer),
                ) {

                    IconComponent(icon = Icons.Rounded.AddPhotoAlternate)

                }
                Spacer(modifier = Modifier.height(height = 8.dp))
                TextButton(onClick = onClickAddPicture) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = stringResource(R.string.add_picture))
                    }
                }

            }
        } else {
            Column {

                bitmap = if (Build.VERSION.SDK_INT < 28) {
                    MediaStore.Images
                        .Media.getBitmap(context.contentResolver, imageUri)
                } else {
                    val source = ImageDecoder.createSource(context.contentResolver, imageUri)
                    ImageDecoder.decodeBitmap(source)
                }
                bitmap?.let { btm ->
                    Image(
                        modifier = Modifier
                            .size(size = 130.dp)
                            .clip(shape = RoundedCornerShape(size = 65.dp))
                            .clickable { onClickImageField() },
                        bitmap = btm.asImageBitmap(),
                        contentScale = ContentScale.Crop,
                        contentDescription = stringResource(id = R.string.image)
                    )
                }


                Spacer(modifier = Modifier.height(height = 8.dp))
                TextButton(onClick = onClickDelete) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconComponent(icon = Icons.Rounded.Delete)
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        Text(text = stringResource(R.string.supprimer))
                    }
                }
            }
        }

    }

}