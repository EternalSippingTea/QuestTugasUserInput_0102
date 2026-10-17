package com.example.questtugasuserinput_102

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = colorResource(R.color.form_purple),
        uncheckedColor = colorResource(R.color.form_border)
    )

    val sheetShape = RoundedCornerShape(
        topStart = 32.dp,
        topEnd = 32.dp
    )

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.bg4),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .shadow(
                    elevation = 20.dp,
                    shape = sheetShape,
                    clip = false,
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                ),
            shape = sheetShape,
            color = colorResource(R.color.form_white),
            shadowElevation = 20.dp
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 22.dp)
                    .navigationBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.form_title),
                        color = colorResource(R.color.form_purple),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = stringResource(R.string.form_subtitle),
                        color = colorResource(R.color.form_hint),
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = {
                                Text(
                                    text = stringResource(R.string.first_name),
                                    fontSize = 12.sp
                                )
                            },
                            textStyle = LocalTextStyle.current.copy(fontSize = 13.sp),
                            singleLine = true,
                            shape = textFieldShape,
                            colors = formTextFieldColors,
                            modifier = Modifier
                                .weight(1f)
                        )

                        OutlinedTextField(
                            value = lastName,
                            onValueChange = { lastName = it },
                            label = {
                                Text(
                                    text = stringResource(R.string.last_name),
                                    fontSize = 12.sp
                                )
                            },
                            textStyle = LocalTextStyle.current.copy(fontSize = 13.sp),
                            singleLine = true,
                            shape = textFieldShape,
                            colors = formTextFieldColors,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = {
                            Text(
                                text = stringResource(R.string.email),
                                fontSize = 12.sp
                            )
                        },
                        textStyle = LocalTextStyle.current.copy(fontSize = 13.sp),
                        singleLine = true,
                        shape = textFieldShape,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        colors = formTextFieldColors,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))


                }





