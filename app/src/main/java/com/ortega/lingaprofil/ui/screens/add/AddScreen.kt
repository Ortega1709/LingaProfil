package com.ortega.lingaprofil.ui.screens.add

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.LocalActivityResultRegistryOwner
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Warehouse
import androidx.compose.material.icons.rounded.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.data.datasource.ProfileEntity
import com.ortega.lingaprofil.ui.components.BottomSheetComponent
import com.ortega.lingaprofil.ui.components.ImageFieldComponent
import com.ortega.lingaprofil.ui.components.SnackBarComponent
import com.ortega.lingaprofil.ui.components.TextComponent
import com.ortega.lingaprofil.ui.components.TextFieldComponent
import com.ortega.lingaprofil.ui.components.TopBarComponent
import kotlinx.coroutines.launch
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(viewModel: AddViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    var showModalBottomSheet by rememberSaveable { mutableStateOf(false) }
    var showSnackBar by rememberSaveable { mutableStateOf(false) }

    var nameTextField by rememberSaveable { mutableStateOf("") }
    var phoneTextField by rememberSaveable { mutableStateOf("") }
    var professionTextField by rememberSaveable { mutableStateOf("") }

    var emailTextField by rememberSaveable { mutableStateOf("") }
    var addressTextField by rememberSaveable { mutableStateOf("") }
    var imageTextField by rememberSaveable { mutableStateOf("") }

    // get uri of image uploaded
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // gallery launcher
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
            showModalBottomSheet = false
        }

    Scaffold (
        topBar = {
            TopBarComponent(
                icon = Icons.Rounded.Close,
                title = stringResource(id = R.string.create_new),
                action = {
                    Button(
                        onClick = {
                            if (nameTextField != "") {
                                if (imageUri != null) {

                                    // save image and get his path
                                    imageTextField = viewModel.saveImageToInternalStorage(context, imageUri!!)

                                    val profile = ProfileEntity(
                                        null,
                                        name = nameTextField,
                                        phone = phoneTextField,
                                        profession = professionTextField,
                                        email = emailTextField,
                                        address = addressTextField,
                                        image = imageTextField,
                                        false
                                    )

                                    // save profile and finish current activity
                                    viewModel.saveProfile(profile)
                                    (context as? Activity)?.finish()

                                } else {
                                    val profile = ProfileEntity(
                                        null,
                                        name = nameTextField,
                                        phone = phoneTextField,
                                        profession = professionTextField,
                                        email = emailTextField,
                                        address = addressTextField,
                                        image = imageTextField,
                                        false
                                    )

                                    viewModel.saveProfile(profile)
                                    (context as? Activity)?.finish()

                                }
                            } else { showSnackBar = true }
                        }
                    ) {
                        Text(text = stringResource(id = R.string.save))
                    }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = {
            if (showSnackBar) {
                SnackBarComponent(
                    message = stringResource(R.string.require_name),
                    onActionClick = { showSnackBar = false }
                )
            }
        }
    ) {

        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(all = 16.dp)
        ) {

            item {
                ImageFieldComponent(
                    imageUri = imageUri,
                    onClickDelete = { imageUri = null },
                    onClickAddPicture = { showModalBottomSheet = true },
                    onClickImageField = { showModalBottomSheet = true },
                )
                Spacer(modifier = Modifier.height(height = 16.dp))


                TextFieldComponent(
                    value = nameTextField,
                    label = stringResource(id = R.string.name),
                    onValueChange = { nameTextField = it },
                    icon = Icons.Rounded.Person
                )

                Spacer(modifier = Modifier.height(height = 8.dp))

                TextFieldComponent(
                    value = phoneTextField,
                    label = stringResource(R.string.phone),
                    onValueChange = { phoneTextField = it },
                    icon = Icons.Rounded.Phone,
                    keyboardType = KeyboardType.Phone
                )

                Spacer(modifier = Modifier.height(height = 8.dp))

                TextFieldComponent(
                    value = professionTextField,
                    label = stringResource(R.string.profession),
                    onValueChange = { professionTextField = it },
                    icon = Icons.Rounded.Work
                )

                Spacer(modifier = Modifier.height(height = 8.dp))

                TextFieldComponent(
                    value = emailTextField,
                    label = stringResource(R.string.email),
                    onValueChange = { emailTextField = it },
                    icon = Icons.Rounded.Email,
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(height = 8.dp))

                TextFieldComponent(
                    value = addressTextField,
                    label = stringResource(R.string.address),
                    onValueChange = { addressTextField = it },
                    icon = Icons.Rounded.Home
                )

            }
        }
    }

    if (showModalBottomSheet) {
        BottomSheetComponent(
            onDismiss = { showModalBottomSheet = false },
            onClickCamera = {  },
            onClickGallery = { launcher.launch("image/*") }
        )
    }
}

