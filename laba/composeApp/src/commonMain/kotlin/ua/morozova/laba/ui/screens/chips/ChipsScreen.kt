package ua.morozova.laba.ui.screens.chips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.morozova.laba.App
import ua.morozova.laba.ui.theme.AppTheme

@Composable
fun ChipsScreen () {
    var selected by remember { mutableStateOf(false) }
    var inputVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        AssistChip(
            onClick = { println("Assist chip: settings clicked") },
            label = { Text("Assist chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        FilterChip(
            onClick = { selected = !selected },
            label = {
                Text("Filter chip")
            },
            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        if (inputVisible) {
            InputChip(
                onClick = {
                    inputVisible = false
                },
                label = { Text("Mage Player") },
                selected = true,
                avatar = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Avatar icon",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                },
                trailingIcon = {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Close icon",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            )
        } else {
            TextButton(onClick = { inputVisible = true }) {
                Text("Restore Input Chip")
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        SuggestionChip(
            onClick = { println("Suggestion chip: hello world") },
            label = { Text("Suggestion chip") }
        )
    }
}

@Preview
@Composable
fun ChipsScreenPreview() {
    AppTheme {
        Scaffold {
            ChipsScreen()
        }
    }
}