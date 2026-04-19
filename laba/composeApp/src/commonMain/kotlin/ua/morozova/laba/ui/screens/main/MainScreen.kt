package ua.morozova.laba.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import laba.composeapp.generated.resources.Res
import laba.composeapp.generated.resources.buttons
import laba.composeapp.generated.resources.checkboxes
import laba.composeapp.generated.resources.chips
import laba.composeapp.generated.resources.datepickers
import laba.composeapp.generated.resources.dialogs
import laba.composeapp.generated.resources.dividers
import laba.composeapp.generated.resources.progressbars
import laba.composeapp.generated.resources.radiobuttons
import laba.composeapp.generated.resources.switchs
import laba.composeapp.generated.resources.timepickers
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    onButtonsClicked: () -> Unit,
    onCheckboxesClicked: () -> Unit,
    onChipsClicked: () -> Unit,
    onDatepickersClicked: () -> Unit,
    onDialogsClicked: () -> Unit,
    onDividersClicked: () -> Unit,
    onProgressbarsClicked: () -> Unit,
    onRadiobuttonsClicked: () -> Unit,
    onSwitchsClicked: () -> Unit,
    onTimepickersClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonsClicked()
            }
        ) {
            Text(stringResource(Res.string.buttons))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onCheckboxesClicked()
            }
        ) {
            Text(stringResource(Res.string.checkboxes))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onChipsClicked()
            }
        ) {
            Text(stringResource(Res.string.chips))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onDatepickersClicked()
            }
        ) {
            Text(stringResource(Res.string.datepickers))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onDialogsClicked()
            }
        ) {
            Text(stringResource(Res.string.dialogs))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onDividersClicked()
            }
        ) {
            Text(stringResource(Res.string.dividers))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onProgressbarsClicked()
            }
        ) {
            Text(stringResource(Res.string.progressbars))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onRadiobuttonsClicked()
            }
        ) {
            Text(stringResource(Res.string.radiobuttons))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSwitchsClicked()
            }
        ) {
            Text(stringResource(Res.string.switchs))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onTimepickersClicked()
            }
        ) {
            Text(stringResource(Res.string.timepickers))
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        onButtonsClicked = {},
        onCheckboxesClicked = {},
        onChipsClicked = {},
        onDatepickersClicked = {},
        onDialogsClicked = {},
        onDividersClicked = {},
        onProgressbarsClicked = {},
        onRadiobuttonsClicked = {},
        onSwitchsClicked = {},
        onTimepickersClicked = {}
    )
}