package com.example.questtugasuserinput_102

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
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
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
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

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = birthDate,
                            onValueChange = {},
                            readOnly = true,
                            singleLine = true,
                            label = {
                                Text(
                                    text = stringResource(R.string.birth_date),
                                    fontSize = 12.sp,
                                    maxLines = 1
                                )
                            },
                            textStyle = LocalTextStyle.current.copy(fontSize = 13.sp),
                            shape = textFieldShape,
                            trailingIcon = {
                                IconButton(
                                    onClick = { showDatePicker = true },
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_calendar),
                                        contentDescription = null,
                                        tint = colorResource(R.color.form_text),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            },
                            colors = formTextFieldColors,
                            modifier = Modifier
                                .weight(1f)
                        )

                        ExposedDropdownMenuBox(
                            expanded = showExperienceMenu,
                            onExpandedChange = {
                                showExperienceMenu = !showExperienceMenu
                            },
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = {},
                                readOnly = true,
                                singleLine = true,
                                label = {
                                    Text(
                                        text = stringResource(R.string.experience),
                                        fontSize = 12.sp,
                                        maxLines = 1
                                    )
                                },
                                textStyle = LocalTextStyle.current.copy(fontSize = 13.sp),
                                shape = textFieldShape,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(
                                        expanded = showExperienceMenu
                                    )
                                },
                                colors = formTextFieldColors,
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = showExperienceMenu,
                                onDismissRequest = {
                                    showExperienceMenu = false
                                }
                            ) {
                                listOf(
                                    stringResource(R.string.exp_less_than_1),
                                    stringResource(R.string.exp_1_2_years),
                                    stringResource(R.string.exp_3_5_years),
                                    stringResource(R.string.exp_more_than_5)
                                ).forEach { level ->
                                    DropdownMenuItem(
                                        text = { Text(level, color = colorResource(R.color.form_text), fontSize = 13.sp) },
                                        onClick = {
                                            experience = level
                                            showExperienceMenu = false
                                        }
                                    )
                                }
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = stringResource(R.string.choose_skill),
                        color = colorResource(R.color.form_text),
                        fontSize = 13.sp,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = androidSkill,
                                onCheckedChange = { androidSkill = it },
                                colors = checkboxColors
                            )
                            Text(
                                text = stringResource(R.string.skill_android),
                                color = colorResource(R.color.form_text),
                                fontSize = 12.sp
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = uiuxSkill,
                                onCheckedChange = { uiuxSkill = it },
                                colors = checkboxColors
                            )
                            Text(
                                text = stringResource(R.string.skill_uiux),
                                color = colorResource(R.color.form_text),
                                fontSize = 12.sp
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = webSkill,
                                onCheckedChange = { webSkill = it },
                                colors = checkboxColors
                            )
                            Text(
                                text = stringResource(R.string.skill_web),
                                color = colorResource(R.color.form_text),
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    val requiredFieldsText = stringResource(R.string.required_fields)
                    val skillAndroidText = stringResource(R.string.skill_android)
                    val skillUiuxText = stringResource(R.string.skill_uiux)
                    val skillWebText = stringResource(R.string.skill_web)
                    val resultTitleText = stringResource(R.string.result_title)
                    val resultNameText = stringResource(R.string.result_name)
                    val resultEmailText = stringResource(R.string.result_email)
                    val resultBirthDateText = stringResource(R.string.result_birth_date)
                    val resultExperienceText = stringResource(R.string.result_experience)
                    val resultSkillsText = stringResource(R.string.result_skills)

                    Button(
                        onClick = {
                            if (
                                firstName.isBlank() ||
                                lastName.isBlank() ||
                                email.isBlank()
                            ) {
                                scope.launch {
                                    snackbarHostState.showSnackbar(requiredFieldsText)
                                }
                            } else {
                                val skills = buildList {
                                    if (androidSkill) add(skillAndroidText)
                                    if (uiuxSkill) add(skillUiuxText)
                                    if (webSkill) add(skillWebText)
                                }.joinToString()

                                val message = """
                                    $resultTitleText
                                    $resultNameText: $firstName $lastName
                                    $resultEmailText: $email
                                    $resultBirthDateText: $birthDate
                                    $resultExperienceText: $experience
                                    $resultSkillsText: $skills
                                """.trimIndent()

                                scope.launch {
                                    snackbarHostState.showSnackbar(message)
                                }
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.proceed),
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE2E2E2))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.12f),
                                    Color.Transparent
                                )
                            )
                        )
                )

                // White bottom bar area
                Spacer(modifier = Modifier.height(36.dp))
            }
        }

        if (showDatePicker) {
            val datePickerState = rememberDatePickerState()

            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            datePickerState.selectedDateMillis?.let { millis ->
                                birthDate = SimpleDateFormat(
                                    "dd/MM/yyyy",
                                    Locale.getDefault()
                                ).format(Date(millis))
                            }
                            showDatePicker = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDatePicker = false }
                    ) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}






