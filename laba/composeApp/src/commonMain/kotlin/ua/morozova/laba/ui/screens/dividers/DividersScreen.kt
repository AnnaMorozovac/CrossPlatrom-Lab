package ua.morozova.laba.ui.screens.dividers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import ua.morozova.laba.ui.theme.AppTheme
import co.touchlab.kermit.Logger

@Composable
fun DividersScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text("First item in list")
            HorizontalDivider(thickness = 2.dp)
            Text("Second item in list")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("First item in row")
            VerticalDivider(color = MaterialTheme.colorScheme.secondary)
            Text("Second item in row")
        }
    }
}

@Preview
@Composable
fun DividersScreenPreview() {
    AppTheme {
        Scaffold {
            DividersScreen()
        }
    }
}