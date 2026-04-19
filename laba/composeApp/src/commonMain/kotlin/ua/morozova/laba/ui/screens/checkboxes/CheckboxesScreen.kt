package ua.morozova.laba.ui.screens.checkboxes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.morozova.laba.ui.theme.AppTheme

@Composable
fun CheckboxesScreen() {
    var checked by remember { mutableStateOf(true) }

    val childCheckedStates = remember { mutableStateListOf(false, false, false) }

    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Minimal checkbox")
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Select all")
                TriStateCheckbox(
                    state = parentState,
                    onClick = {
                        val newState = parentState != ToggleableState.On
                        childCheckedStates.forEachIndexed { index, _ ->
                            childCheckedStates[index] = newState
                        }
                    }
                )
            }

            childCheckedStates.forEachIndexed { index, isChildChecked ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text("Option ${index + 1}")
                    Checkbox(
                        checked = isChildChecked,
                        onCheckedChange = { isChecked ->
                            childCheckedStates[index] = isChecked
                        }
                    )
                }
            }

            if (childCheckedStates.all { it }) {
                Text("All options selected", modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Preview
@Composable
fun CheckboxesScreenPreview() {
    AppTheme {
        Scaffold {
            CheckboxesScreen()
        }
    }
}