package ua.morozova.laba.ui.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import laba.composeapp.generated.resources.Res
import laba.composeapp.generated.resources.buttons
import org.jetbrains.compose.resources.stringResource

@Composable
fun ButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Text(stringResource(Res.string.buttons))
    }
}