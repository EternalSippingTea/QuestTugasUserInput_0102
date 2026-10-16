package com.example.questtugasuserinput_102

import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

import androidx.compose.ui.Modifier

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var androidSkill by remember { mutableStateOf(false) }
    var uiuxSkill by remember { mutableStateOf(false) }
    var webSkill by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }
    var showExperienceMenu by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val textFieldShape = RoundedCornerShape(12.dp)

    val formTextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = colorResource(R.color.form_text),
        unfocusedTextColor = colorResource(R.color.form_text),
        focusedLabelColor = colorResource(R.color.form_purple),
        unfocusedLabelColor = colorResource(R.color.form_hint),
        focusedBorderColor = colorResource(R.color.form_purple),
        unfocusedBorderColor = colorResource(R.color.form_border)
    )


}

