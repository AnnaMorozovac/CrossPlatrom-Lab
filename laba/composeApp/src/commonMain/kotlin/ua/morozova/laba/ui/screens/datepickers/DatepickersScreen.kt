package ua.morozova.laba.ui.screens.datepickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.tooling.preview.Preview
import ua.morozova.laba.data.timezones.TimeZoneHelper
import ua.morozova.laba.data.timezones.TimeZoneHelperImpl
import ua.morozova.laba.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatepickersScreen() {
    val timeHelper: TimeZoneHelper = remember { TimeZoneHelperImpl() }

    var showDockedPicker by remember { mutableStateOf(false) }
    val dockedState = rememberDatePickerState()

    var showModalPicker by remember { mutableStateOf(false) }
    var selectedModalDateText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = dockedState.selectedDateMillis?.let { timeHelper.formatMillis(it) } ?: "",
                onValueChange = { },
                label = { Text("Click icon") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showDockedPicker = !showDockedPicker }) {
                        Icon(Icons.Default.DateRange, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (showDockedPicker) {
                Popup(
                    onDismissRequest = { showDockedPicker = false },
                    alignment = Alignment.TopStart
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 64.dp)
                            .shadow(elevation = 8.dp)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(8.dp)
                    ) {
                        DatePicker(state = dockedState, showModeToggle = false)
                    }
                }
            }
        }

        HorizontalDivider()

        OutlinedTextField(
            value = selectedModalDateText,
            onValueChange = { },
            label = { Text("Click to open modal") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { showModalPicker = true }) {
                    Icon(Icons.Default.DateRange, contentDescription = null)
                }
            }
        )

        if (showModalPicker) {
            DatePickerModal(
                onDateSelected = { millis ->
                    selectedModalDateText = millis?.let { timeHelper.formatMillis(it) } ?: ""
                },
                onDismiss = { showModalPicker = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@Preview(showBackground = true)
@Composable
fun DatepiackersScreenPreview() {
    AppTheme {
        Scaffold {
            DatepickersScreen()
        }
    }
}