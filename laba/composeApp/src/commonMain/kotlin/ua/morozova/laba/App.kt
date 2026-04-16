package ua.morozova.laba

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

import ua.morozova.laba.ui.screens.AppNavigation
import ua.morozova.laba.ui.theme.AppTheme
import ua.morozova.laba.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavigation()
    }
}