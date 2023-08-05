package com.ortega.lingaprofil.ui.screens.add

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
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
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.lingaprofil.R
import com.ortega.lingaprofil.ui.components.BottomSheetComponent
import com.ortega.lingaprofil.ui.components.TextComponent
import com.ortega.lingaprofil.ui.components.TextFieldComponent
import com.ortega.lingaprofil.ui.components.TopBarComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(viewModel: AddViewModel = hiltViewModel()) {

    val context = LocalContext.current

    var showModalBottomSheet by rememberSaveable {
        mutableStateOf(false)
    }

    var nameTextField by remember { mutableStateOf("") }
    var phoneTextField by remember { mutableStateOf("") }
    var professionTextField by remember { mutableStateOf("") }

    var emailTextField by remember { mutableStateOf("") }
    var addressTextField by remember { mutableStateOf("") }
    var imageTextField by remember { mutableStateOf("") }


    Scaffold (
        topBar = {
            TopBarComponent(
                title = stringResource(id = R.string.create_new),
                action = {
                    Button(
                        onClick = {
                            showModalBottomSheet = true
                        }
                    ) {
                        Text(text = stringResource(id = R.string.save))
                    }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                }
            )     
        },
    ) {

        Column (
            modifier = Modifier
                .padding(it)
                .padding(all = 16.dp)
        ) {




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

    if (showModalBottomSheet) {
        BottomSheetComponent(
            onDismiss = { showModalBottomSheet = false },
            onClickCamera = {  },
            onClickGallery = {  }
        )
    }
}