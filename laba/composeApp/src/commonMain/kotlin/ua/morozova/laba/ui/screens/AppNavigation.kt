package ua.morozova.laba.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import laba.composeapp.generated.resources.*
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import ua.morozova.laba.ui.screens.buttons.ButtonsScreen
import ua.morozova.laba.ui.screens.checkboxes.CheckboxesScreen
import ua.morozova.laba.ui.screens.chips.ChipsScreen
import ua.morozova.laba.ui.screens.datepickers.DatepickersScreen
import ua.morozova.laba.ui.screens.dialogs.DialogsScreen
import ua.morozova.laba.ui.screens.dividers.DividersScreen
import ua.morozova.laba.ui.screens.progressbars.ProgressbarsScreen
import ua.morozova.laba.ui.screens.main.MainScreen
import ua.morozova.laba.ui.screens.radiobuttons.RadiobuttonsScreen
import ua.morozova.laba.ui.screens.switchs.SwitchsScreen
import ua.morozova.laba.ui.screens.timepickers.TimepickerScreen

enum class AppScreen(val title: StringResource) {
    Main(title = Res.string.main), Buttons(title = Res.string.buttons), Checkboxes(title = Res.string.checkboxes),
    Chips(title = Res.string.chips), Datepickers(title = Res.string.datepickers), Dialogs(title = Res.string.dialogs),
    Dividers(title = Res.string.dividers), Progressbras(title = Res.string.progressbars), Radiobuttons(title = Res.string.radiobuttons),
    Switchs(title = Res.string.switchs), Timepickers(title = Res.string.timepickers)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.back)
                    )
                }
            }
        })
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = try {
        AppScreen.valueOf(backStackEntry?.destination?.route ?: AppScreen.Main.name)
    } catch (e: Exception) {
        AppScreen.Main
    }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreen.Main.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = AppScreen.Main.name) {
                MainScreen(
                    onButtonsClicked = { navController.navigate(AppScreen.Buttons.name) },
                    onCheckboxesClicked = { navController.navigate(AppScreen.Checkboxes.name) },
                    onChipsClicked = { navController.navigate(AppScreen.Chips.name) },
                    onDatepickersClicked = { navController.navigate(AppScreen.Datepickers.name) },
                    onDialogsClicked = { navController.navigate(AppScreen.Dialogs.name) },
                    onDividersClicked = { navController.navigate(AppScreen.Dividers.name) },
                    onProgressbarsClicked = { navController.navigate(AppScreen.Progressbras.name) },
                    onRadiobuttonsClicked = { navController.navigate(AppScreen.Radiobuttons.name) },
                    onSwitchsClicked = { navController.navigate(AppScreen.Switchs.name) },
                    onTimepickersClicked = { navController.navigate(AppScreen.Timepickers.name) },
                    )
            }
            composable(route = AppScreen.Buttons.name) {
                ButtonsScreen(
                    onFilledButtonClicked = { text ->
                        scope.launch {
                            snackbarHostState
                                .showSnackbar(
                                    message = text,
                                    duration = SnackbarDuration.Short
                                )
                        }
                    }
                )
            }
            composable(route = AppScreen.Checkboxes.name) {
                CheckboxesScreen()
            }

            composable(route = AppScreen.Chips.name) {
                ChipsScreen()
            }

            composable(route = AppScreen.Datepickers.name) {
                DatepickersScreen()
            }

            composable(route = AppScreen.Dialogs.name) {
                DialogsScreen()
            }

            composable(route = AppScreen.Dividers.name) {
                DividersScreen()
            }

            composable(route = AppScreen.Progressbras.name) {
                ProgressbarsScreen()
            }

            composable(route = AppScreen.Radiobuttons.name) {
                RadiobuttonsScreen()
            }

            composable(route = AppScreen.Switchs.name) {
                SwitchsScreen()
            }

            composable(route = AppScreen.Timepickers.name) {
                TimepickerScreen()
            }
        }
    }
}